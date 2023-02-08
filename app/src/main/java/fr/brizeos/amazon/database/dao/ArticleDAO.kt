package fr.brizeos.amazon.database.dao

import androidx.room.*
import fr.brizeos.amazon.model.Article
import fr.brizeos.amazon.model.converters.ArticleConverters

@Dao
@TypeConverters(ArticleConverters::class)
interface ArticleDAO {

    @Insert
    suspend fun insertAll(articles: List<Article>): List<Long>

    @Query("SELECT * FROM Article")
    fun getAll(): List<Article>

    @Query("SELECT * FROM Article WHERE id = :id")
    suspend fun getById(id: Int): Article

    @Delete
    fun delete(article: Article)

}