package com.example.e.fintech_app.news.data

import android.content.Context
import com.example.e.fintech_app.news.domain.models.Article
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
import javax.inject.Inject

class NewsApiImpl @Inject constructor (
    private val context: Context
) : NewsApi {

    private val articles = mutableListOf<Article>()

    override suspend fun getRecentArticles(limit: Int): List<Article> {
        if (articles.isEmpty()) getArticles()
        return articles.take(limit)
    }

    override suspend fun getAllArticles(limit: Int): List<Article> {
        if (articles.isEmpty()) getArticles()
        return articles.drop(limit)
    }

    private suspend fun getArticles(){
        withContext(Dispatchers.IO){
            val news = ""
            news.fromJsonAsset("news.json")?.let {
                val jsonObject = JSONObject(it)
                val articlesJson = jsonObject.getJSONArray("articles")
                val articles: List<Article> =
                    Gson().fromJson(
                        articlesJson.toString(),
                        object : TypeToken<List<Article>>() {}.type
                    )
                this@NewsApiImpl.articles.addAll(articles)
            }
        }
    }

    // extensions function to get string from json file
    fun String.fromJsonAsset(fileName : String) : String? {
        val data: String? = try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charset.defaultCharset())
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return data
    }

}