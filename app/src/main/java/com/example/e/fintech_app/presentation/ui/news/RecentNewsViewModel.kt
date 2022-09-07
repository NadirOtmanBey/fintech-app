package com.example.e.fintech_app.presentation.ui.news

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e.fintech_app.domain.models.Article
import com.example.e.fintech_app.presentation.state.ViewState
import com.example.e.fintech_app.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecentNewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _recentNewsViewState = MutableLiveData<ViewState>()
    val recentNewsViewState: LiveData<ViewState> = _recentNewsViewState

    val recentNews: MutableState<List<Article>> = mutableStateOf(listOf())

    init{ getRecentNews() }

    fun getRecentNews(){
        viewModelScope.launch {
            _recentNewsViewState.value = ViewState.Loading
            val list = newsRepository.getRecentArticles()
            if(list.isNotEmpty()){
                _recentNewsViewState.value = ViewState.Content(list)
                recentNews.value = list
            }
        }
    }

}