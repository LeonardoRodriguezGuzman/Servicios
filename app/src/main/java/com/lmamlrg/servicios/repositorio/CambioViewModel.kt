package com.lmamlrg.servicios.repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.lmamlrg.servicios.db.Cambio

class CambioViewModel(private val reporitorioCambio: RepositorioCambio) : ViewModel() {
    val cambio : LiveData<List<Cambio>> = reporitorioCambio.cambio.asLiveData()
}

class CambioViewModelFactory(private val repositorioCambio: RepositorioCambio) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CambioViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return CambioViewModel(repositorioCambio) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}