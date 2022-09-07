package com.example.e.fintech_app.presentation.state

import com.example.e.fintech_app.domain.models.Article

sealed class ViewState{
    object Loading: ViewState()
    object Error: ViewState()
    data class Content(val data: Any?): ViewState()
}
