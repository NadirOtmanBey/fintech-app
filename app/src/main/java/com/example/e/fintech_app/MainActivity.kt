package com.example.e.fintech_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.e.fintech_app.news.repository.NewsRepository
import com.example.e.fintech_app.stock_tickers.repository.StocksRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
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
            GlobalScope.launch {
                news.getRecentArticles().forEach(){
                    Log.e("test", it.toString())
                }

                stocks.getStocks().collect(){
                    Log.e("test", it[0].toString())
                }
            }
        }
    }

    @Preview
    @Composable
    private fun test(){
        Text(text = "Hello nadir")
    }
}