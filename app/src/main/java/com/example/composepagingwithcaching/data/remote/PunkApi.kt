package com.example.composepagingwithcaching.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface PunkApi {

    @GET("beers")
    suspend fun getBeer(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ):List<BeerDto>

    companion object{
        const val BASE_URL_PUNK = "https://api.punkapi.com/v2/"
    }
}