package fr.brizeos.amazon.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import fr.brizeos.amazon.model.converters.ArticleConverters

@Entity
@TypeConverters(ArticleConverters::class)
data class ArticleLine(
    @PrimaryKey(autoGenerate = false)
    val productId :Article,
    var quantity :Int)
