package com.example.e.fintech_app.domain.models.repository

import com.example.e.fintech_app.domain.models.Article

interface NewsRepository {

    suspend fun getRecentArticles(): List<Article>

    suspend fun getAllArticles(): List<Article>

}