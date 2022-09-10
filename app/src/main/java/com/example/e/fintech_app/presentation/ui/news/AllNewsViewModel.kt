package com.example.e.fintech_app.presentation.ui.news

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e.fintech_app.domain.models.Article
import com.example.e.fintech_app.presentation.state.ViewState
import com.example.e.fintech_app.domain.models.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllNewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _allNewsViewState = MutableLiveData<ViewState>()
    val allNewsViewState: LiveData<ViewState> = _allNewsViewState

    val allNews: MutableState<List<Article>> = mutableStateOf(listOf())

    init{ getAllNews() }

    fun getAllNews(){
        viewModelScope.launch {
            _allNewsViewState.value = ViewState.Loading
            val list = newsRepository.getAllArticles()
            if(list.isNotEmpty()){
                _allNewsViewState.value = ViewState.Content(list)
                allNews.value = list
            }
        }
    }


}