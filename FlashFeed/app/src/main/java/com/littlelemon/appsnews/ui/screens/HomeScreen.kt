package com.littlelemon.appsnews.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.littlelemon.appsnews.ui.components.EmptyState
import com.littlelemon.appsnews.ui.components.Loader
import com.littlelemon.appsnews.ui.components.NewsRowComponent
import com.littlelemon.appsnews.ui.viewmodel.NewsViewModel
import com.littlelemon.utilities.ResourceState
const val TAG = "HomeScreen"
//@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(newsViewModel: NewsViewModel = hiltViewModel()){
    val newsRes by  newsViewModel.news.collectAsState()
    val articleCount = if (newsRes is ResourceState.Success) {
        (newsRes as ResourceState.Success).data.articles.size
    } else {
        1
    }
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ){
        articleCount
    }
    VerticalPager(state = pagerState, modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp ){page :Int->
        when(newsRes){
            is ResourceState.Loading ->{
                Log.d(TAG,"Inside_Loading")
                Loader()
            }
            is ResourceState.Success ->{
                val response =  (newsRes as ResourceState.Success).data
            if(response.articles.isNotEmpty()){
                NewsRowComponent(page, response.articles[page])

            }
                else{
                    EmptyState()
            }
            }
            is ResourceState.Error ->{
                val error =  (newsRes as ResourceState.Error)

                Log.d(TAG, error.message)

            }
        }
    }



}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}