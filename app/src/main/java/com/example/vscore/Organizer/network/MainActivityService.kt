package com.example.vscore.Organizer.network

import com.example.vscore.Organizer.model.CodeResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MainActivityService {
    @GET
    fun getRoomCode(
    @Url url: String,
//    @Query("id") id:String?
    ): Call<CodeResponseModel>
}