package com.example.mamamarket.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mamamarket.entity.Product
import com.example.mamamarket.repo.ProductsDaoRepository

class KampanyalarFragmentViewModel: ViewModel() {
    var kampanyaliUrunlerListesi = MutableLiveData<List<Product>>()
    private val pdaoi = ProductsDaoRepository()


    init {
        kampanyaliUrunleriYukle()
    }

    fun kampanyaliUrunleriYukle() {
        pdaoi.kampanyaliUrunleriAl()
        kampanyaliUrunlerListesi = pdaoi.kampanyaliUrunListAl()
        Log.e("kampanyalistesi",kampanyaliUrunlerListesi.value?.size.toString())

    }

}