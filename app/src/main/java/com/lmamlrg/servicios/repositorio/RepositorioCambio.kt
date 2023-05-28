package com.lmamlrg.servicios.repositorio

import com.lmamlrg.servicios.db.Cambio
import com.lmamlrg.servicios.db.CambioDAO
import kotlinx.coroutines.flow.Flow

class RepositorioCambio (private val cambioDAO: CambioDAO) {
    val cambio: Flow<List<Cambio>>
    get() = cambioDAO.getAll()
}