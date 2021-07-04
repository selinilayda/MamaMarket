package com.example.mamamarket.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.mamamarket.fragment.KayitOlFragment
import com.example.mamamarket.repo.UsersDaoRepository

class KayitOlFragmentViewModel: ViewModel() {
    val udaor = UsersDaoRepository()

    fun kayit(myContext:Context,user_mail: String,user_password: String, user_fullName: String, user_phoneNumber: String){

        udaor.kayit(myContext,user_mail,user_password,user_fullName,user_phoneNumber)



    }

}