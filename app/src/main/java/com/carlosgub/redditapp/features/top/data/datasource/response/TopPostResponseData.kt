package com.carlosgub.redditapp.features.top.data.datasource.response

data class TopPostResponse(
    val data: DataTopPostResponse
)

data class DataTopPostResponse(
    val children: List<ChildrenDataTopPostResponse>
)

data class ChildrenDataTopPostResponse(
    val data: DataChildrenDataTopPostResponse
)

data class DataChildrenDataTopPostResponse(
    val title: String
)