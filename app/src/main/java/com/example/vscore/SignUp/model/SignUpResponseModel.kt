package com.example.vscore.SignUp.model

import com.google.gson.annotations.SerializedName

data class SignUpResponseModel (

    @SerializedName("name"     ) var name     : String?           = null,
    @SerializedName("email"    ) var email    : String?           = null,
    @SerializedName("password" ) var password : String?           = null,
    @SerializedName("role"     ) var role     : String?           = null,
    @SerializedName("_id"      ) var Id       : String?           = null,
    @SerializedName("matches"  ) var matches  : ArrayList<String> = arrayListOf(),
    @SerializedName("__v"      ) var _v       : Int?              = null

)