package com.example.mamamarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.mamamarket.fragment.GirisYapFragment

import com.example.mamamarket.viewmodel.LoginFragmentViewModel


class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val titleList = arrayListOf("KayitOl", "OturumAc")

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, GirisYapFragment())
        transaction.commit()

        val temp: LoginFragmentViewModel by viewModels()
        viewModel = temp


    }

}