package com.lmamlrg.servicios.conexion

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .build()

private const val BASE_URL = "https://v6.exchangerate-api.com/v6/1ff295fc7f1679d1997ce5f7/latest/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ExchangeRateAPI {
    @GET("MXN")
    suspend fun getExchangeRateAPI():Response
}
object exchangeRateAPI {
    val retrofitService : ExchangeRateAPI by lazy {
        retrofit.create(ExchangeRateAPI::class.java)
    }
}