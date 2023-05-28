package com.lmamlrg.servicios.work

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.lmamlrg.servicios.MainActivity
import com.lmamlrg.servicios.conexion.ExchangeRateAPI
import com.lmamlrg.servicios.conexion.exchangeRateAPI
import com.lmamlrg.servicios.db.Cambio
import com.lmamlrg.servicios.db.MonedasDB
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime

val TAG = "WORKER"
private lateinit var db : MonedasDB
@RequiresApi(Build.VERSION_CODES.O)
val fechaActual = LocalDateTime.now()

class syncWorker (appContext: Context, workerParams : WorkerParameters) : Worker(appContext, workerParams){
    @RequiresApi(Build.VERSION_CODES.O)
    override fun doWork(): Result {
        return try{
            GlobalScope.launch {
                db = (applicationContext as MainActivity).database
                try {
                    val response = exchangeRateAPI.retrofitService.getExchangeRateAPI()
                    Log.d("Api Response", "Ejecutando")
                    for ((key, values) in response.rates){
                        db.cambioDAO().insertar(Cambio(0, key, values.toString(), response.time_last_update_utc, fechaActual.toString()))
                        println("Clave: $key , Valor:$values")
                    }
                    println("Ultima Actualización: ${response.time_last_update_utc}")
                }catch (e : Exception){
                    Log.d(TAG, "Error:${e}")

                }
            }
            Result.success()
        } catch (e: Exception){
            Log.e(TAG, "Ha ocurrido el siguiente error durante la sincronizacion: ${e.message}")
            return Result.failure()
        }
    }

}