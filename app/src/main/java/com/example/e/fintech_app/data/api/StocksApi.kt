package com.example.e.fintech_app.data.api

import com.example.e.fintech_app.domain.models.Stock
import kotlinx.coroutines.flow.Flow

interface StocksApi {

    fun getStocks(): Flow<List<Stock>>

}