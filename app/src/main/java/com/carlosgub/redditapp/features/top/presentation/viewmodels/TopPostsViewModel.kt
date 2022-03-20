package com.carlosgub.redditapp.features.top.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carlosgub.redditapp.core.interactor.Interactor
import com.carlosgub.redditapp.features.top.domain.interactor.GetTopPostInteractor
import com.carlosgub.redditapp.features.top.presentation.model.mapper.PostMapper
import com.carlosgub.redditapp.features.top.presentation.viewmodels.states.TopPostVS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TopPostsViewModel @Inject constructor(
    private val getTopPostInteractor: GetTopPostInteractor
) : ViewModel() {

    val viewState: LiveData<TopPostVS> get() = mViewState
    private val mViewState = MutableLiveData<TopPostVS>()
    private var job: Job? = null

    fun getTopPost() {
        mViewState.value = TopPostVS.ShowLoader(true)
        job = CoroutineScope(Dispatchers.IO).launch {
            getTopPostInteractor.execute(Interactor.None)
                .collect {
                    withContext(Dispatchers.Main) {
                        mViewState.value = TopPostVS.TopPosts(PostMapper.map(it))
                    }
                }
            withContext(Dispatchers.Main){
                mViewState.value = TopPostVS.ShowLoader(false)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}