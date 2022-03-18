package com.carlosgub.redditapp.features.top.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carlosgub.redditapp.databinding.ActivityTopBinding

class TopActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        "https://www.reddit.com/top/.json"
    }
}