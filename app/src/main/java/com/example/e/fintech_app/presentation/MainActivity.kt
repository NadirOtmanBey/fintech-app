package com.example.e.fintech_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.e.fintech_app.domain.models.Article
import com.example.e.fintech_app.domain.models.Stock
import com.example.e.fintech_app.presentation.components.allNewsCard
import com.example.e.fintech_app.presentation.components.recentNewsCard
import com.example.e.fintech_app.presentation.components.stocksCard
import com.example.e.fintech_app.presentation.ui.news.AllNewsViewModel
import com.example.e.fintech_app.presentation.ui.news.RecentNewsViewModel
import com.example.e.fintech_app.presentation.ui.stocks.StockTickersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var stockTickersViewModel: StockTickersViewModel
    private lateinit var recentNewsViewModel: RecentNewsViewModel
    private lateinit var allNewsViewModel: AllNewsViewModel

    private var stocks : MutableState<List<Stock>> = mutableStateOf(listOf())
    private var recentArticles : MutableState<List<Article>> = mutableStateOf(listOf())
    private var allArticles : MutableState<List<Article>> = mutableStateOf(listOf())

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        stockTickersViewModel = ViewModelProvider(this)[StockTickersViewModel::class.java]
        recentNewsViewModel = ViewModelProvider(this)[RecentNewsViewModel::class.java]
        allNewsViewModel = ViewModelProvider(this)[AllNewsViewModel::class.java]

        lifecycleScope.launch{
            // for better performance, limit collect when activity in background
            repeatOnLifecycle(Lifecycle.State.STARTED){
                stockTickersViewModel.stocks.value.collect{ stocksList ->
                    stocks.value = stocksList  }
            }
        }

        recentArticles = recentNewsViewModel.recentNews
        allArticles = allNewsViewModel.allNews

            setContent {
            Column(modifier = Modifier
                .fillMaxWidth()) {

                stockSection()

                recentNewsSection()

                allNewsSection()
            }
        }
    }

    @Composable
    fun stockSection(){
        Column(modifier = Modifier.background(Color.White))
        {
            Surface(modifier = Modifier.fillMaxWidth()) {
                Column{
                    Text(text = "Stocks",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(start = 8.dp, bottom = 8.dp))

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())) {
                        stocks.value.forEach{ stock -> stocksCard(stock = stock) }
                    }
                }
            }
        }
    }

    @Composable
    fun recentNewsSection(){
        Surface(modifier = Modifier.fillMaxWidth()) {
                Column{
                    Text(text = "Recent News",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(start = 8.dp, bottom = 8.dp))

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                    ) {
                        recentArticles.value.forEach{ article -> recentNewsCard(article) }
                    }
                }
        }
    }

    @Composable
    fun allNewsSection(){
        Text(text = "All News",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 8.dp, bottom = 8.dp))

       LazyColumn{
           itemsIndexed(items = allArticles.value) {index, article ->
                   allNewsCard(article)
               }
       }
    }

}




