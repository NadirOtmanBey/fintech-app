package com.example.e.fintech_app.di

import android.content.Context
import com.example.e.fintech_app.data.api.NewsApi
import com.example.e.fintech_app.data.api.NewsApiImpl
import com.example.e.fintech_app.repository.NewsRepository
import com.example.e.fintech_app.repository.NewsRepositoryImpl
import com.example.e.fintech_app.data.api.StocksApi
import com.example.e.fintech_app.data.api.StocksApiImpl
import com.example.e.fintech_app.repository.StocksRepository
import com.example.e.fintech_app.repository.StocksRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun newsApi(@ApplicationContext context: Context): NewsApi {
        return NewsApiImpl(context)
    }

    @Provides
    @Singleton
    fun newsRepository(newsApi: NewsApi): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun stocksApi(@ApplicationContext context: Context): StocksApi {
        return StocksApiImpl(context)
    }

    @Provides
    @Singleton
    fun stocksRepository(stocksApi: StocksApi): StocksRepository {
        return StocksRepositoryImpl(stocksApi)
    }

}