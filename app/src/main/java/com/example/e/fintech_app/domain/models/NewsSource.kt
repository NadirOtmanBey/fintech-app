package com.example.e.fintech_app.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsSource (
    val id: String,
    val name: String
) : Parcelable
