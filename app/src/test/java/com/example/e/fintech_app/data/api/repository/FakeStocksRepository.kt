package com.example.e.fintech_app.data.api.repository

import com.example.e.fintech_app.domain.models.Stock
import com.example.e.fintech_app.domain.models.repository.StocksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeStocksRepository : StocksRepository {

    private val stocks = mutableListOf<Stock>()

    override suspend fun getStocks(): Flow<List<Stock>> {
        return flow { emit(stocks) }
    }

    fun addStocks( stocks : List<Stock>){
        this.stocks.addAll(stocks)
    }

}