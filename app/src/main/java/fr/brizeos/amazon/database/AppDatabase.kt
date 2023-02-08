package fr.brizeos.amazon.database

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.brizeos.amazon.database.dao.ArticleDAO
import fr.brizeos.amazon.database.dao.CartDAO
import fr.brizeos.amazon.model.Article
import fr.brizeos.amazon.model.ArticleLine
import fr.brizeos.amazon.model.Cart

@Database(entities = [Cart::class, Article::class, ArticleLine::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cartDAO(): CartDAO
    abstract fun articleDAO(): ArticleDAO

}