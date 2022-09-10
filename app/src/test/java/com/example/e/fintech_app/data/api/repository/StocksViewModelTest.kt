package com.example.e.fintech_app.data.api.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.e.fintech_app.CoroutineTestRule
import com.example.e.fintech_app.domain.models.Stock
import com.example.e.fintech_app.presentation.ui.stocks.StockTickersViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.random.Random

@OptIn(ExperimentalCoroutinesApi::class)
class StocksViewModelTest {

    private lateinit var fakeStocksRepository : FakeStocksRepository
    private val fakeStocks = mutableListOf<Stock>()
    private lateinit var stocksViewModel : StockTickersViewModel

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Before
    fun setUp() {
        fakeStocksRepository = FakeStocksRepository()
        ('a'..'z').forEach {
            fakeStocks.add(Stock(it.toString(),Random.nextFloat()))
        }
        fakeStocksRepository.addStocks(fakeStocks)
        stocksViewModel = StockTickersViewModel(fakeStocksRepository)
    }

    @Test
    fun `is viewModel receiving correct data from repo `() {
        var stocksFromViewMode: List<Stock>
        stocksViewModel.getStocks()
        runBlocking { stocksFromViewMode = stocksViewModel.stocks.value.first() }
        assertEquals(fakeStocks.size, stocksFromViewMode.size)
        assertEquals(fakeStocks.first().symbol, stocksFromViewMode.first().symbol)
    }

}