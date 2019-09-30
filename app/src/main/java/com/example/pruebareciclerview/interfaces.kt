package com.example.pruebareciclerview

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PupusasApiService {
    @GET("rellenos")
    fun getRellenos() : Call<RellenoWrapper>
    @POST("orden")
    fun submitOrden(@Body params: Pupusa) : Call<Pupusa>
}
