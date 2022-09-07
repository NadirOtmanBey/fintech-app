package com.example.e.fintech_app.news.repository

import com.example.e.fintech_app.news.domain.models.Article

interface NewsRepository {

    suspend fun getRecentArticles(): List<Article>

    suspend fun getAllArticles(): List<Article>

}