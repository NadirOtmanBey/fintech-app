package com.example.e.fintech_app.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.e.fintech_app.domain.models.Article
import com.example.e.fintech_app.util.loadImage


@Composable
fun recentNewsCard(
    article : Article
){

    Card(shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
    ) {
        Column(modifier = Modifier.width(310.dp)){
            article.urlToImage.let {
                val image = loadImage(url = it).value
                image?.let { it ->
                    Image(bitmap = it.asImageBitmap(),
                        contentDescription = article.content ?: "",
                        modifier = Modifier.height(200.dp).fillMaxWidth(),
                        contentScale = ContentScale.Crop)
                }
            }

            Text(text = article.title,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)
            
        }
    }

}