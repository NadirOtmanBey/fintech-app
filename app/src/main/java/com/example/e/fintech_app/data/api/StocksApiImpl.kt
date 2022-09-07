package com.example.e.fintech_app.data.api

import android.content.Context
import com.example.e.fintech_app.domain.models.Stock
import com.opencsv.CSVReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

class StocksApiImpl @Inject constructor(
    private val context: Context
) : StocksApi {

    private val stocks = mutableListOf<Stock>()

    // to save stock symbols; set for unique
    private val symbols = mutableSetOf<String>()

    override fun getStocks(): Flow<List<Stock>> {
        if (stocks.isEmpty()) getStocksFromCSV()
        return flow {
            while (true) {
                val stocksUpdate = mutableListOf<Stock>()
                symbols.forEach{ symbol ->
                    val instance = stocks.filter{ symbol == it.symbol }.random()
                    stocksUpdate.add(instance)
                }
                emit(stocksUpdate)
                delay(1000)
            }
        }.flowOn(Dispatchers.IO)
    }

    private fun getStocksFromCSV() {
        val inputStreamReader = InputStreamReader(context.assets.open("stocks.csv"))
        val bufferedReader = BufferedReader(inputStreamReader)
        val reader = CSVReader(bufferedReader)
        reader.readNext()
        while (reader.peek() != null) {
            val line = reader.readNext()
            val symbol = line[0]
            symbols.add(symbol)
            val price = line[1].toFloat()
            stocks.add(Stock(symbol, price))
        }
    }

}