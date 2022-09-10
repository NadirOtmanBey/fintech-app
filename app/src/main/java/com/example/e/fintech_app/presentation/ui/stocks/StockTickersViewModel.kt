package com.example.e.fintech_app.presentation.ui.stocks

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e.fintech_app.domain.models.Stock
import com.example.e.fintech_app.presentation.state.ViewState
import com.example.e.fintech_app.domain.models.repository.StocksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockTickersViewModel @Inject constructor(
    private val stocksRepository: StocksRepository
) : ViewModel(){

    private val _stockTickersViewState = MutableLiveData<ViewState>()
    val stockTickersViewState: LiveData<ViewState> = _stockTickersViewState

    val stocks: MutableState<Flow<List<Stock>>> = mutableStateOf(flowOf(listOf()))

    init{ getStocks() }

    fun getStocks(){
        viewModelScope.launch{
            _stockTickersViewState.value =  ViewState.Loading
            val list = stocksRepository.getStocks()
            _stockTickersViewState.value = ViewState.Content(list)
            stocks.value = list
            }
    }
}

