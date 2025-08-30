package com.littlelemon.appsnews.data.datasource

import com.littlelemon.appsnews.data.api.ApiService
import com.littlelemon.appsnews.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource {
    override suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadLine(country)

    }
    }