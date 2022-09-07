package com.example.e.fintech_app.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.e.fintech_app.repository.NewsRepository
import com.example.e.fintech_app.repository.StocksRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var news: NewsRepository

    @Inject
    lateinit var stocks: StocksRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            test()
            lifecycleScope.launch {
                news.getRecentArticles().forEach(){
                    Log.e("test", it.toString())
                }

                // for better performance, limit collect when activity in background
                repeatOnLifecycle(Lifecycle.State.STARTED){
                    stocks.getStocks().collect{
                        Log.e("test", it[0].toString())
                    }
                }
                }
            }
        }
    }

    @Preview
    @Composable
    private fun test(){
        Text(text = "Hello nadir")
    }
