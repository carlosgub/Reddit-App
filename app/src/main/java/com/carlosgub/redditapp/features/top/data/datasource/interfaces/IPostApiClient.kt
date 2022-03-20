package com.carlosgub.redditapp.features.top.data.datasource.interfaces

import com.carlosgub.redditapp.features.top.data.datasource.response.TopPostResponse
import retrofit2.http.GET

interface IPostApiClient {
    @GET("/top/.json")
    suspend fun getTopPosts(): TopPostResponse
}