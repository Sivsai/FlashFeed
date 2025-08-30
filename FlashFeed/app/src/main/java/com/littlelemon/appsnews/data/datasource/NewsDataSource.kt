package com.littlelemon.appsnews.data.datasource

import com.littlelemon.appsnews.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {
    suspend fun getNewsHeadline(country: String): Response<NewsResponse>
}