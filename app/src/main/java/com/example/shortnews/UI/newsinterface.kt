package com.example.shortnews.UI

import retrofit2.Call
import retrofit2.http.GET

interface newsinterface {

    @GET("/v2/top-headlines?country=in&apiKey=09f4d8346fba450d9a3652518b3d5d26")
    fun getNews():Call<Newsdata>


}