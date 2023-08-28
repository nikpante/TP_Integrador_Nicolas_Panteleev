package com.nicolaspanteleev.tpintegrador

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel :ViewModel() {
    val comparador: LiveData<Comparador> get() = _comparador
    private var _comparador = MutableLiveData<Comparador>(Comparador("",""))

    fun updateComparador(newTextOne:String,newTextTwo:String){
        viewModelScope.launch {
            _comparador.value = Comparador(newTextOne, newTextTwo)
        }
    }
}