package com.carlosgub.redditapp.features.top.domain.interactor

import com.carlosgub.redditapp.core.interactor.Interactor
import com.carlosgub.redditapp.features.top.data.datasource.response.DataChildrenDataTopPostResponse
import com.carlosgub.redditapp.features.top.domain.repository.TopPostRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopPostInteractor @Inject constructor(
    private val topPostRepository: TopPostRepository
) : Interactor<Interactor.None, Flow<DataChildrenDataTopPostResponse>> {

    override fun execute(params: Interactor.None): Flow<DataChildrenDataTopPostResponse> =
        topPostRepository.getTopPosts()
}