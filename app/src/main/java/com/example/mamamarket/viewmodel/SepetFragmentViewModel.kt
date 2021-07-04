package com.example.mamamarket.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mamamarket.entity.Product
import com.example.mamamarket.repo.ProductsDaoRepository

class SepetFragmentViewModel: ViewModel() {
    var sepetUrunListesi = MutableLiveData<List<Product>>()

    private val pdaoi = ProductsDaoRepository()

    init {
     sepetiYukle()
    }

    fun sepetiYukle(){
        pdaoi.sepettekiTumUrunleriAl()
        sepetUrunListesi = pdaoi.sepetUrunListGetir()

    }
}