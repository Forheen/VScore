package com.example.vscore.SignUp.model

import com.google.gson.annotations.SerializedName

data class SignUpRequestModel (
        @SerializedName("name"     ) var name     : String? = null,
        @SerializedName("email"    ) var email    : String? = null,
        @SerializedName("password" ) var password : String? = null,
        @SerializedName("digit" ) var digit : Int? = null
    )