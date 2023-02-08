package fr.brizeos.amazon.repostories

import fr.brizeos.amazon.model.Article
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleRepo {

     @GET("products/{id}")
     fun get(@Query("id") id :Int) :Call<Article>

     @GET("products")
     fun getListLimited(@Query("limit") limit :Int) :Call<List<Article>>

}