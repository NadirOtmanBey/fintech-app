package com.example.e.fintech_app.data.api.repository

import com.example.e.fintech_app.data.api.StocksApi
import com.example.e.fintech_app.domain.models.Stock
import com.example.e.fintech_app.domain.models.repository.StocksRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StocksRepositoryImpl @Inject constructor(
    private val stocksApi: StocksApi
) : StocksRepository {

    override suspend fun getStocks(): Flow<List<Stock>> {
        return stocksApi.getStocks()
    }

}