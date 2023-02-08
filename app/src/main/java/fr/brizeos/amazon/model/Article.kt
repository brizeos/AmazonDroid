package fr.brizeos.amazon.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val title :String,
    val price :Float,
    val description :String,
    val category: String,
    val image :String,
    @Json(name = "rating.rate")
    val rate :Float,
    @Json(name = "rating.count")
    val rate_count :Int,

    )
