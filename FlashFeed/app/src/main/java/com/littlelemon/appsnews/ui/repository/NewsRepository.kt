package com.littlelemon.appsnews.ui.repository

import android.util.Log
import com.littlelemon.appsnews.data.datasource.NewsDataSource
import com.littlelemon.appsnews.data.entity.NewsResponse
import com.littlelemon.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject
class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource

) {


    suspend fun getNewsHeadline(country: String) : Flow<ResourceState<NewsResponse>> {
        return flow{
            emit(ResourceState.Loading())

            val response = newsDataSource.getNewsHeadline(country)

            if(response.isSuccessful&&response.body()!=null){
                emit(ResourceState.Success(response.body()!!))
            }else{

                emit(ResourceState.Error("Error fetching news data"))

            }

        }.catch { e->

            emit(ResourceState.Error(e.localizedMessage ?:"Some error in the Flow"))
        }
    }


}