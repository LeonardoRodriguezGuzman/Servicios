package com.lmamlrg.servicios.repositorio

import com.lmamlrg.servicios.db.Moneda
import com.lmamlrg.servicios.db.MonedaDAO
import kotlinx.coroutines.flow.Flow

class RepositorioMoneda (private val monedaDAO: MonedaDAO){
    val moneda : Flow<List<Moneda>>
    get() = monedaDAO.getAll()
}