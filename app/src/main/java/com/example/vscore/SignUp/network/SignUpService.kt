package com.example.vscore.SignUp.network

import com.example.vscore.Login.model.SignInRequestModel
import com.example.vscore.SignUp.model.SignUpRequestModel
import com.example.vscore.SignUp.model.SignUpResponseModel
import retrofit2.Call
import retrofit2.http.*

interface SignUpService  {
    @POST
    fun registerApiCall(
        @Url url: String,
        @Body loginRequestModel: SignUpRequestModel
    ): Call<SignUpResponseModel>
}
