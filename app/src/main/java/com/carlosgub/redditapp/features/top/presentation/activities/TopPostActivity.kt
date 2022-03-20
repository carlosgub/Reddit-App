package com.carlosgub.redditapp.features.top.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlosgub.redditapp.databinding.ActivityTopPostBinding
import com.carlosgub.redditapp.features.top.presentation.adapters.TopPostAdapter
import com.carlosgub.redditapp.features.top.presentation.viewmodels.TopPostsViewModel
import com.carlosgub.redditapp.features.top.presentation.viewmodels.states.TopPostVS
import dagger.hilt.android.AndroidEntryPoint
import android.content.Intent
import android.net.Uri

@AndroidEntryPoint
class TopPostActivity : AppCompatActivity(), TopPostAdapter.Listener {

    private lateinit var binding: ActivityTopPostBinding
    lateinit var viewModel: TopPostsViewModel
    private val postAdapter = TopPostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopPostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setAdapter()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[TopPostsViewModel::class.java]
        viewModel.viewState.observe(this, {
            when (it) {
                is TopPostVS.TopPosts -> {
                    postAdapter.add(it.posts)
                }
                is TopPostVS.ShowLoader -> {
                    binding.rvMain.isVisible = !it.showLoader
                    binding.pbTopPost.isVisible = it.showLoader
                }
                is TopPostVS.Error -> {

                }
            }
        })
        postAdapter.clear()
        viewModel.getTopPost()
    }

    private fun setAdapter(){
        postAdapter.setListener(this)
        binding.rvMain.apply {
            layoutManager = LinearLayoutManager(this@TopPostActivity)
            adapter = postAdapter
        }
    }

    override fun onPostClicked(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }
}