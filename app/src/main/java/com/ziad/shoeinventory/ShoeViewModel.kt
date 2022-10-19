package com.ziad.shoeinventory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel: ViewModel() {
    var shoe = Shoe("", 0.0, "", "")
    private val shoeList = mutableListOf<Shoe?>()
    private val _shoes = MutableLiveData<List<Shoe?>>()
    val shoes: LiveData<List<Shoe?>>
        get() = _shoes

    fun addNewShoe(){
        shoeList.add(shoe)

        shoe = Shoe("", 0.0, "", "")
        _shoes.value = shoeList
    }
}