package com.example.e.fintech_app.stock_tickers.repository

import com.example.e.fintech_app.stock_tickers.data.StocksApi
import com.example.e.fintech_app.stock_tickers.domain.Stock
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StocksRepositoryImpl @Inject constructor(
    private val stocksApi: StocksApi
) : StocksRepository {

    override suspend fun getStocks(): Flow<List<Stock>> {
        return stocksApi.getStocks()
    }

}