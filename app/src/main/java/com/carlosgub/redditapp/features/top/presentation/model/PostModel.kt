package com.carlosgub.redditapp.features.top.presentation.model

import androidx.annotation.StringRes

data class PostModel(
    val title: String,
    val author: String,
    val thumbnail: String,
    val numberOfComments: Int,
    val time: Int,
    @StringRes val timeUnit: Int,
    val url:String
)