package com.carlosgub.redditapp.features.top.presentation.viewmodels.states

import com.carlosgub.redditapp.features.top.presentation.model.PostModel

sealed class TopPostVS {
    class TopPosts(val posts: PostModel):TopPostVS()
    class ShowLoader(val showLoader:Boolean):TopPostVS()
}