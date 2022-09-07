package com.example.e.fintech_app.di

import android.content.Context
import com.example.e.fintech_app.news.data.NewsApi
import com.example.e.fintech_app.news.data.NewsApiImpl
import com.example.e.fintech_app.news.repository.NewsRepository
import com.example.e.fintech_app.news.repository.NewsRepositoryImpl
import com.example.e.fintech_app.stock_tickers.data.StocksApi
import com.example.e.fintech_app.stock_tickers.data.StocksApiImpl
import com.example.e.fintech_app.stock_tickers.repository.StocksRepository
import com.example.e.fintech_app.stock_tickers.repository.StocksRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun newsApi(@ApplicationContext context: Context): NewsApi {
        return NewsApiImpl(context)
    }

    @Provides
    fun newsRepository(newsApi: NewsApi): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

    @Provides
    fun stocksApi(@ApplicationContext context: Context): StocksApi {
        return StocksApiImpl(context)
    }

    @Provides
    fun stocksRepository(stocksApi: StocksApi): StocksRepository {
        return StocksRepositoryImpl(stocksApi)
    }

}