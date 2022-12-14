package com.example.e.fintech_app.data.api.repository

import com.example.e.fintech_app.data.api.NewsApi
import com.example.e.fintech_app.domain.models.Article
import com.example.e.fintech_app.domain.models.repository.NewsRepository
import javax.inject.Inject

private const val RECENT_NEWS_LIMIT = 6

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsRepository {

    override suspend fun getRecentArticles(): List<Article> {
        return newsApi.getRecentArticles(RECENT_NEWS_LIMIT)
    }

    override suspend fun getAllArticles(): List<Article> {
        return newsApi.getAllArticles(RECENT_NEWS_LIMIT)
    }

}