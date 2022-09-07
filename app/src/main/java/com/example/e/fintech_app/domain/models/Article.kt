package com.example.e.fintech_app.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article (
    val source: NewsSource? = null,
    val author: String? = null,
    val title: String,
    val description: String,
    val url: String? = null,
    val urlToImage: String,
    val publishedAt: String,
    val content: String? = null,
) : Parcelable