package fr.brizeos.amazon.di

import fr.brizeos.amazon.repostories.ArticleRepo
import fr.brizeos.amazon.repostories.CartRepo
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val networkModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    single<ArticleRepo> {
        get<Retrofit>().create<ArticleRepo>()
    }

    single<CartRepo> {
        get<Retrofit>().create<CartRepo>()
    }
}

