package com.example.e.fintech_app.presentation.ui.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.e.fintech_app.presentation.state.ViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecentNewsFragment : Fragment() {

    private val viewModel: RecentNewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("test","recent news ${viewModel.recentNews.value[0]}")

        viewModel.recentNewsViewState.observe(viewLifecycleOwner) { state ->
            when(state){
                is ViewState.Content -> TODO()
                ViewState.Error -> TODO()
                ViewState.Loading -> TODO()
            }
        }
    }

}