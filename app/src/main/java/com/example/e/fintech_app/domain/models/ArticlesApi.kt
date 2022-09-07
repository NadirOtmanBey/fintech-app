package com.example.e.fintech_app.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticlesApi(

    // we can separate network model from domain model from entity model
    // and use mapper between them; this method for further maintainability.
    // in this case i'll just use domain model.

    val status: String,
    val articles: List<Article> = listOf()
) : Parcelable
