package com.example.shortnews.UI

data class Newsdata(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)