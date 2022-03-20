package com.carlosgub.redditapp.features.top.data.datasource.response

import com.google.gson.annotations.SerializedName

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
    val title: String,
    @SerializedName("author_fullname") val author:String,
    val thumbnail:String,
    @SerializedName("num_comments") val numberOfComments:Int,
    @SerializedName("created_utc") val created:Long,
    val url:String
)