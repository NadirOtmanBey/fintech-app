package com.example.e.fintech_app.presentation.ui.stocks

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.e.fintech_app.presentation.state.ViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StockTickersFragment: Fragment() {

    private val viewModel: StockTickersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.stockTickersViewState.observe(viewLifecycleOwner) { state ->
            when(state){
                is ViewState.Content -> TODO()
                ViewState.Error -> TODO()
                ViewState.Loading -> TODO()
            }
        }

        lifecycleScope.launch{
            // for better performance, limit collect when activity in background
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.stocks.value.collect{
                    Log.e("test","first stock ${it[0]}" )
                }
            }
        }
    }

}