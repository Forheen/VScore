package com.example.vscore.Login.model

import com.google.gson.annotations.SerializedName

data class SignInRequestModel (
    @SerializedName("email"    ) var email    : String? = null,
    @SerializedName("password" ) var password : String? = null,
    @SerializedName("digit" ) var digit : Int? = null
)
