package com.example.vscore.Login.respository

import androidx.lifecycle.MutableLiveData
import com.example.vscore.AppUrls
import com.example.vscore.Login.model.SignInRequestModel
import com.example.vscore.Login.network.LoginService
import com.example.vscore.RetrofitUtil
import com.example.vscore.SignUp.model.SignUpRequestModel
import com.example.vscore.SignUp.model.SignUpResponseModel
import com.example.vscore.SignUp.network.SignUpService
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository() {
    val showProgress = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    val signUpResponseMutableLiveData = MutableLiveData<SignUpResponseModel>()

    fun loginApiCall(signInRequestModel: SignInRequestModel) {
        showProgress.value = true
        val url=AppUrls.ORGANIZATION_LOGIN_URL
        val client = RetrofitUtil.getRetrofit()?.create(LoginService::class.java)
        var call = client?.loginApiCall(url, signInRequestModel)
        call?.enqueue(object : Callback<SignUpResponseModel?> {
            override fun onResponse(
                call: Call<SignUpResponseModel?>,
                response: Response<SignUpResponseModel?>
            ) {
                showProgress.postValue(false)
                val body = response.body()

                if (response.isSuccessful) {
                    body?.let {
                        signUpResponseMutableLiveData.postValue(body)
                    }
                } else {
                    val jObjError = JSONObject(response.errorBody()?.string())
                    errorMessage.postValue(jObjError.getString("message"))
                }
            }

            override fun onFailure(call: Call<SignUpResponseModel?>, t: Throwable) {
                showProgress.postValue(false)
                errorMessage.postValue("Server error please try after sometime")
            }
        })
    }

}