package com.carlosgub.redditapp.features.top.presentation.viewmodels.states

import com.carlosgub.redditapp.features.top.data.datasource.response.DataChildrenDataTopPostResponse

sealed class TopPostVS {
    class TopPosts(val posts: DataChildrenDataTopPostResponse):TopPostVS()
    class Error(val message:String?):TopPostVS()
    class ShowLoader(val showLoader:Boolean):TopPostVS()
}