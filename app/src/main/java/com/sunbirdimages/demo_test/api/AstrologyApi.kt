package com.sunbirdimages.demo_test.api

import com.sunbirdimages.demo_test.data.AstrologyData
import retrofit2.http.GET

interface AstrologyApi {
    companion object {
        const val BASE_URL = "https://api.nasa.gov/"
    }


    @GET("planetary/apod?api_key=DEMO_KEY&start_date=2021-08-04")
    suspend fun getAstrologyData(): List<AstrologyData>
}