package com.example.e.fintech_app.news.data

import com.example.e.fintech_app.news.domain.models.Article

interface NewsApi {

    suspend fun getRecentArticles(limit: Int): List<Article>

    suspend fun getAllArticles(limit: Int): List<Article>

}