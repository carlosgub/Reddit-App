package com.carlosgub.redditapp.features.top.domain.repository

import com.carlosgub.redditapp.features.top.data.datasource.response.DataChildrenDataTopPostResponse
import kotlinx.coroutines.flow.Flow

interface TopPostRepository {
    fun getTopPosts(): Flow<DataChildrenDataTopPostResponse>
}