package com.example.e.fintech_app.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.e.fintech_app.domain.models.Stock

@Composable
fun stocksCard(
    stock : Stock
){

    Card(shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
    ) {
        Row(modifier = Modifier.padding(8.dp))
            {
                Text(text = stock.symbol,
                    modifier = Modifier.wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight(600))

                val formattedPrice: Float = String.format("%.2f", stock.price).toFloat()

                Text(text = formattedPrice.toString()+" USD",
                    modifier = Modifier.padding(start = 16.dp)
                                       .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.body1,
                    color = if (formattedPrice>0) Color.Green else Color.Red)
            }
        }
}