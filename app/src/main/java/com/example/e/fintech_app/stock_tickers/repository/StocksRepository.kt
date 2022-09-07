package com.example.e.fintech_app.stock_tickers.repository

import com.example.e.fintech_app.stock_tickers.domain.Stock
import kotlinx.coroutines.flow.Flow

interface StocksRepository {

   suspend fun getStocks(): Flow<List<Stock>>

}