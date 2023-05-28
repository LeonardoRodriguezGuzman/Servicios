package com.lmamlrg.servicios.repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.lmamlrg.servicios.db.Moneda

class MonedaViewModel (private val repositorioMoneda: RepositorioMoneda) : ViewModel() {
    val moneda: LiveData<List<Moneda>> = repositorioMoneda.moneda.asLiveData()
}

class MonedaViewModelFactory(private val repositorioMoneda: RepositorioMoneda) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((MonedaViewModel::class.java))){
            @Suppress("UNCHECKED_CAST")
            return MonedaViewModel(repositorioMoneda) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }
}