package com.littlelemon.appsnews.data.entity

data class NewsResponse(
    val status: String,
    val totalResults :Int ,
    val articles : List<Article>

)
data class Article(

    val author: String?, // CORRECT: Marked as nullable


    val content: String?, // Good practice to make this nullable too


    val description: String?, // Good practice to make this nullable too


    val publishedAt: String,


    val source: Source,


    val title: String,


    val url: String,


    val urlToImage: String? // Image URLs are often null

)
data class Source(
    val id : String?,
    val name : String
)
