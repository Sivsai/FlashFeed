package com.littlelemon.appsnews.data.api

import com.littlelemon.appsnews.data.AppConstants
import com.littlelemon.appsnews.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("v2/top-headlines")
   suspend fun getNewsHeadLine(
        @Query("country") country: String,
        @Header("X-Api-Key") apiKey: String = AppConstants.API_KEY
    ):Response<NewsResponse>
}
//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=API_KEY