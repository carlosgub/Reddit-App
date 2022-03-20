package com.carlosgub.redditapp.features.top.presentation.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.carlosgub.redditapp.databinding.ActivityTopPostBinding
import com.carlosgub.redditapp.features.top.presentation.viewmodels.TopPostsViewModel
import com.carlosgub.redditapp.features.top.presentation.viewmodels.states.TopPostVS
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopPostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTopPostBinding
    lateinit var viewModel: TopPostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopPostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViewModel()

        // "https://www.reddit.com/top/.json"
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[TopPostsViewModel::class.java]
        viewModel.viewState.observe(this, {
            when (it) {
                is TopPostVS.TopPosts -> {
                    Toast.makeText(this, it.posts.title, Toast.LENGTH_LONG).show()
                }
            }
        })
        viewModel.getTopPost()
    }
}