package com.example.e.fintech_app.presentation.ui.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import com.example.e.fintech_app.presentation.state.ViewState

@AndroidEntryPoint
class AllNewsFragment :Fragment(){

    private val viewModel: AllNewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.allNewsViewState.observe(viewLifecycleOwner) { state ->
            when(state){
                is ViewState.Content -> TODO()
                ViewState.Error -> TODO()
                ViewState.Loading -> TODO()
            }
        }

    }


}