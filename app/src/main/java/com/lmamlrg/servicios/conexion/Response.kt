package com.lmamlrg.servicios.conexion

import com.squareup.moshi.Json

data class Response(
    @Json(name = "time_last_uptdate_utc") val time_last_update_utc: String,
    @Json(name = "rates") val rates : Map<String, Double>
)
