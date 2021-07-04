package com.example.mamamarket.viewmodel

import android.os.Looper
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mamamarket.entity.Product
import com.example.mamamarket.repo.ProductsDaoRepository
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import java.util.logging.Handler

class AnasayfaFragmentViewModel : ViewModel() {
    var urunlerListesi = MutableLiveData<List<Product>>()
    private val pdaoi = ProductsDaoRepository()


    init {
        urunleriYukle()


    }

    fun urunleriYukle() {
        pdaoi.tumUrunleriAl()
        urunlerListesi = pdaoi.urunleriAl()
    }

}