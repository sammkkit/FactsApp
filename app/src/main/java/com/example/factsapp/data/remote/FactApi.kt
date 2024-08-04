package com.example.factsapp.data.remote

import com.example.factsapp.R
import com.example.factsapp.domain.model.Fact
import com.example.factsapp.domain.model.FactItem
import retrofit2.http.GET
import retrofit2.http.Query

interface FactApi {

    @GET("facts")
    suspend fun getfacts(
        @Query("X-api-key") apiKey: String = API_KEY
    ): Fact

    companion object{
        val API_KEY = "CEAId2j5Rcz7eChGHf5jfg==1t9mHGdsdyy5MTaz"
        val BASE_URL = "https://api.api-ninjas.com/v1/"
    }
}