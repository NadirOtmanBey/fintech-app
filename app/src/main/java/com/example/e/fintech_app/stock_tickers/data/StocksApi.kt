package com.example.e.fintech_app.stock_tickers.data

import com.example.e.fintech_app.stock_tickers.domain.Stock
import kotlinx.coroutines.flow.Flow

interface StocksApi {

    fun getStocks(): Flow<List<Stock>>

}