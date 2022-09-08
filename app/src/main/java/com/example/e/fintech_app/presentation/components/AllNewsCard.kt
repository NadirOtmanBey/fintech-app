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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.e.fintech_app.domain.models.Article
import com.example.e.fintech_app.util.loadImage

@Composable
fun allNewsCard(
    article : Article
){

    Card(shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
    ) {
        Row(modifier = Modifier.padding(8.dp).fillMaxWidth(),
        ) {
            article.urlToImage.let { url ->
                val image = loadImage(url = url).value
                image?.let { it ->
                    Image(bitmap = it.asImageBitmap(),
                        contentDescription = article.content ?: "",
                        modifier = Modifier
                            .fillMaxSize(0.4f)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop) }
            }

            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(text = article.title,
                    modifier = Modifier.wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight(600),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(text = article.description,
                    modifier = Modifier.padding(top = 8.dp)
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.body1,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis)

                Text(text = article.publishedAt,
                    modifier = Modifier.padding(top = 8.dp)
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.caption,)

            }
        }
    }

}