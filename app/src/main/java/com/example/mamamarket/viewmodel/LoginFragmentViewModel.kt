package com.example.mamamarket.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mamamarket.entity.Users
import com.example.mamamarket.repo.UsersDaoRepository

class LoginFragmentViewModel: ViewModel() {

    var kisilerListesi = MutableLiveData<List<Users>>()
    val udaor = UsersDaoRepository()


    init {

        kisilerListesi = udaor.kisileriGetir()
    }

    fun oturumAc(myContext:Context,user_mail: String,user_password: String) {
        udaor.oturumAc(myContext,user_mail,user_password)
        udaor.kisileriGetir()
    }
}