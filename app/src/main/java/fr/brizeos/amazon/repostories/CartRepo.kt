package fr.brizeos.amazon.repostories

import fr.brizeos.amazon.model.Cart
import retrofit2.Call
import retrofit2.http.GET

interface CartRepo {

     @GET("cart")
     fun get(): Call<List<Cart>>

}