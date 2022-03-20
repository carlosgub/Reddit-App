package com.carlosgub.redditapp.features.top.presentation.model.mapper

import com.carlosgub.redditapp.R
import com.carlosgub.redditapp.features.top.data.datasource.response.DataChildrenDataTopPostResponse
import com.carlosgub.redditapp.features.top.presentation.model.PostModel

object PostMapper {
    fun map(origin: DataChildrenDataTopPostResponse): PostModel {
        val time = ((System.currentTimeMillis() / 1000) - origin.created).toInt()
        val pair = obtainTime(time)
        return PostModel(
            title = origin.title,
            author = origin.author,
            thumbnail = origin.thumbnail,
            numberOfComments = origin.numberOfComments,
            time = pair.first,
            timeUnit = pair.second,
            url = origin.url
        )
    }

    private fun obtainTime(
        time: Int,
    ): Pair<Int, Int> {
        val timeTemp: Int
        val timeUnit: Int
        when {
            time < 3600 -> {
                timeTemp = time / 60
                timeUnit = R.string.time_unit_minute
            }
            else -> {
                timeTemp = time / 3600
                timeUnit = R.string.time_unit_hours
            }
        }
        return Pair(timeTemp, timeUnit)
    }
}