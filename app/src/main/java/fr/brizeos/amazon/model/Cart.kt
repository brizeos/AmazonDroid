package fr.brizeos.amazon.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import fr.brizeos.amazon.model.converters.ListArticleConverters
import java.util.Date

@Entity
@TypeConverters(ListArticleConverters::class)
data class Cart(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val userId :Long,
    val products :List<ArticleLine>
    )
