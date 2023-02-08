package fr.brizeos.amazon.model.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.brizeos.amazon.database.dao.ArticleDAO
import fr.brizeos.amazon.model.Article
import fr.brizeos.amazon.model.ArticleLine

@ProvidedTypeConverter
class ListArticleConverters(private val articleDAO: ArticleDAO) {

    @TypeConverter
    fun toArticle(json: String): List<ArticleLine> {
        val type = object : TypeToken<List<Article>>(){}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(articles :List<ArticleLine>) :String{
        return Gson().toJson(articles)
    }

}