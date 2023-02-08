package fr.brizeos.amazon.di

import androidx.room.Room
import fr.brizeos.amazon.R
import fr.brizeos.amazon.database.AppDatabase
import fr.brizeos.amazon.model.converters.ArticleConverters
import fr.brizeos.amazon.model.converters.ListArticleConverters
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            androidApplication().baseContext.getString(R.string.app_name)
        )
            .addTypeConverter(ArticleConverters::class)
            .addTypeConverter(ListArticleConverters::class)
            .build()
    }

    single { get<AppDatabase>().cartDAO() }
    single { get<AppDatabase>().articleDAO() }
}