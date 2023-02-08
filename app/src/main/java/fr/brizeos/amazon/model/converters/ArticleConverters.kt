package fr.brizeos.amazon.model.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.brizeos.amazon.database.dao.ArticleDAO
import fr.brizeos.amazon.model.Article

@ProvidedTypeConverter
class ArticleConverters(private val articleDAO: ArticleDAO) {

//    @TypeConverter
//    suspend fun toArticle(id :Int) :Article{
//        return articleDAO.getById(id)
//    }

//    @TypeConverter
//    fun toProductId(article :Article) :Int{
//        return article.id
//    }

    @TypeConverter
    fun toArticle(json: String): Article {
        val type = object : TypeToken<Article>(){}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(articleList: Article): String {
        val type = object: TypeToken<Article>(){}.type
        return Gson().toJson(articleList, type)
    }
}