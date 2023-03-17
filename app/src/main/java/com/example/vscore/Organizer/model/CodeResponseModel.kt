package com.example.vscore.Organizer.model

import com.google.gson.annotations.SerializedName

data class CodeResponseModel(
    @SerializedName("_id"              ) var Id            : String?           = null,
    @SerializedName("code"             ) var code          : String?           = null,
    @SerializedName("organiser"        ) var organiser     : Organiser?        = Organiser(),
    @SerializedName("team_no_1_joined" ) var teamNo1Joined : Int?              = null,
    @SerializedName("team_no_2_joined" ) var teamNo2Joined : Int?              = null,
    @SerializedName("gameStatus"       ) var gameStatus    : String?           = null,
    @SerializedName("sets"             ) var sets          : ArrayList<String> = arrayListOf(),
    @SerializedName("__v"              ) var _v            : Int?              = null
)

data class Organiser (
    @SerializedName("_id"  ) var Id   : String? = null,
    @SerializedName("name" ) var name : String? = null
)
