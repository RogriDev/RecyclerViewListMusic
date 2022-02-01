package com.rogrigamer.recyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    //Passo2: Criar atributos referentes ao componentes da minha view
    private val _items = MutableLiveData<List<Music>>()
    val items: LiveData<List<Music>> = _items

    //Passo3: Criar um método para atualizar a lista  de items
    fun getItems() {
        _items.value = MusicData().loadItems()
    }
}