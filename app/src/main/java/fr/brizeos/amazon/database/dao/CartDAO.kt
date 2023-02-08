package fr.brizeos.amazon.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import fr.brizeos.amazon.model.Cart


@Dao
interface CartDAO {

    @Insert
    suspend fun insertAll(carts: List<Cart>): List<Long>

    @Query("SELECT * FROM Cart")
    fun getAll(): List<Cart>

    @Query("SELECT * FROM Cart WHERE id = :id")
    suspend fun getById(id: Int): Cart

    @Delete
    fun delete(cart: Cart)

}