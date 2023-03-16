package com.example.vscore.Login.network

import com.example.vscore.Login.model.SignInRequestModel
import com.example.vscore.SignUp.model.SignUpResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface LoginService {
    @POST
    fun loginApiCall(
        @Url url: String,
        @Body loginRequestModel: SignInRequestModel
    ): Call<SignUpResponseModel>
}