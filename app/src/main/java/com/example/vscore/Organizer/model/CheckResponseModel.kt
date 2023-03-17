package com.example.vscore.Organizer.model

import com.google.gson.annotations.SerializedName

data class CheckResponseModel(
    @SerializedName("team_no_1_joined") val team_no_1_joined: Int,
    @SerializedName("team_no_1_name") val team_no_1_name: String,
    @SerializedName("team_no_2_joined") val team_no_2_joined: Int,
    @SerializedName("team_no_2_name") val team_no_2_name: String
)