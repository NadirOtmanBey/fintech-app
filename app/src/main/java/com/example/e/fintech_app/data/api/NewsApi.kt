package com.example.e.fintech_app.data.api

import com.example.e.fintech_app.domain.models.Article

interface NewsApi {

    suspend fun getRecentArticles(limit: Int): List<Article>

    suspend fun getAllArticles(limit: Int): List<Article>

}