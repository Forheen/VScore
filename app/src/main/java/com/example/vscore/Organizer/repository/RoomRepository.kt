package com.example.vscore.Organizer.repository

import androidx.lifecycle.MutableLiveData
import com.example.vscore.AppUrls
import com.example.vscore.Login.model.SignInRequestModel
import com.example.vscore.Login.network.LoginService
import com.example.vscore.MainActivity
import com.example.vscore.Organizer.model.CheckResponseModel
import com.example.vscore.Organizer.model.CodeResponseModel
import com.example.vscore.Organizer.network.MainActivityService
import com.example.vscore.RetrofitUtil
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoomRepository() {
    val showProgress = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    val codeResponseMutableLiveData = MutableLiveData<CodeResponseModel>()
    val checkResponseMutableLiveData = MutableLiveData<CheckResponseModel>()

    fun codeApiCall(id: String?) {
        showProgress.value = true
        val client = RetrofitUtil.getRetrofit()?.create(MainActivityService::class.java)
        var call = client?.getRoomCode(AppUrls.GET_CODE_URL+"/$id")
        call?.enqueue(object : Callback<CodeResponseModel?> {
            override fun onResponse(
                call: Call<CodeResponseModel?>,
                response: Response<CodeResponseModel?>
            ) {
                showProgress.postValue(false)
                val body = response.body()

                if (response.isSuccessful) {
                    body?.let {
                        codeResponseMutableLiveData.postValue(body)
                    }
                } else {
                    val jObjError = JSONObject(response.errorBody()?.string())
                    errorMessage.postValue(jObjError.getString("message"))
                }
            }

            override fun onFailure(call: Call<CodeResponseModel?>, t: Throwable) {
                showProgress.postValue(false)
                errorMessage.postValue("Server error please try after sometime")
            }
        })
    }

    fun checkApiCall(code: String?) {
        showProgress.value = true
        val client = RetrofitUtil.getRetrofit()?.create(MainActivityService::class.java)
        var call = client?.getRoomCode(AppUrls.Check_URL+"/$code")
        call?.enqueue(object : Callback<CodeResponseModel?> {
            override fun onResponse(
                call: Call<CodeResponseModel?>,
                response: Response<CodeResponseModel?>
            ) {
                showProgress.postValue(false)
                val body = response.body()

                if (response.isSuccessful) {
                    body?.let {
                        codeResponseMutableLiveData.postValue(body)
                    }
                } else {
                    val jObjError = JSONObject(response.errorBody()?.string())
                    errorMessage.postValue(jObjError.getString("message"))
                }
            }

            override fun onFailure(call: Call<CodeResponseModel?>, t: Throwable) {
                showProgress.postValue(false)
                errorMessage.postValue("Server error please try after sometime")
            }
        })
    }
}