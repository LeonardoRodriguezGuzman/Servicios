package com.lmamlrg.servicios.db

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CambioDAO {
    @Insert
    suspend fun insertar(cambio: Cambio)

    @Query("select * from Cambio")
    fun getAll(): kotlinx.coroutines.flow.Flow<List<Cambio>>

    @Query("DELETE FROM CAMBIO")
    fun deleteAll() : Int

    @Query("select * from Cambio order by codeMonedaCambio")
    fun getAllCambioCursor(): Cursor
}