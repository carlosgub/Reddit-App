package com.carlosgub.redditapp.features.top.data.datasource

import com.carlosgub.redditapp.features.top.data.datasource.response.DataChildrenDataTopPostResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TopDataStore {
    fun getTopPosts(): Flow<DataChildrenDataTopPostResponse> = flow {
        PostApiClient.getApiClient().getTopPosts().data.children.map {
            emit(it.data)
        }
    }
}