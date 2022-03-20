package com.carlosgub.redditapp.features.top.data.repository

import com.carlosgub.redditapp.features.top.data.datasource.TopDataStore
import com.carlosgub.redditapp.features.top.data.datasource.response.DataChildrenDataTopPostResponse
import com.carlosgub.redditapp.features.top.domain.repository.TopPostRepository
import kotlinx.coroutines.flow.Flow

class TopPostRepositoryImpl(
    private val topDataStore: TopDataStore
) : TopPostRepository {
    override fun getTopPosts(): Flow<DataChildrenDataTopPostResponse> {
        return topDataStore.getTopPosts()
    }
}