package com.example.e.fintech_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.e.fintech_app.presentation.ui.news.AllNewsFragment
import com.example.e.fintech_app.presentation.ui.news.RecentNewsFragment
import com.example.e.fintech_app.presentation.ui.stocks.StockTickersFragment
import com.example.e.fintech_app.repository.NewsRepository
import com.example.e.fintech_app.repository.StocksRepository
import dagger.hilt.android.AndroidEntryPoint
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

            }
        }
    }

    @Preview
    @Composable
    private fun test(){
        Text(text = "Hello nadir")
    }
