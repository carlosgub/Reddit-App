package com.carlosgub.redditapp.features.top.data.datasource

import com.carlosgub.redditapp.core.network.BaseApiClient
import com.carlosgub.redditapp.features.top.data.datasource.interfaces.IPostApiClient

object PostApiClient : BaseApiClient<IPostApiClient>(IPostApiClient::class.java)