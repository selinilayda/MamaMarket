package com.example.mamamarket.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mamamarket.entity.Product

class UrunDetayFragmentViewModel: ViewModel() {
    var urunListesi = MutableLiveData<List<Product>>()
}
