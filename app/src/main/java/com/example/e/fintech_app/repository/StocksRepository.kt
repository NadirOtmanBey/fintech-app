package com.example.e.fintech_app.repository

import com.example.e.fintech_app.domain.models.Stock
import kotlinx.coroutines.flow.Flow

interface StocksRepository {

   suspend fun getStocks(): Flow<List<Stock>>

}