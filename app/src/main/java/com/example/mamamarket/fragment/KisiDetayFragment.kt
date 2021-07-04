package com.example.mamamarket.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.navArgs
import com.example.mamamarket.R
import com.example.mamamarket.databinding.FragmentKisiDetayBinding
import com.example.mamamarket.entity.Users
import com.example.mamamarket.viewmodel.KisiDetayFragmentViewModel


class KisiDetayFragment : Fragment() {
    private lateinit var tasarim: FragmentKisiDetayBinding
    private lateinit var viewModel: KisiDetayFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_kisi_detay, container, false)

        tasarim.kisiDetayToolbarBaslik = "Kişi Detay"

     //   val bundle: KisiDetayFragmentArgs by navArgs()
     //   val kisiDetay = bundle.kisiDetayGetir



        activity?.let {
            val sharedPreferences = it?.getSharedPreferences("com.example.mamamarket", Context.MODE_PRIVATE)


            val user_fullName = sharedPreferences?.getString("user_fullName", "selin")
            val user_mail = sharedPreferences?.getString("user_mail", "@hotmail.com")
            val user_phoneNumber = sharedPreferences?.getString("user_phoneNumber", "phone number")

            tasarim.kisiNesne = Users(1,user_mail.toString(),"",user_fullName!!,user_phoneNumber!!)


/*
            tasarim.textViewFullName.text = user_fullName
            tasarim.textViewMail.text = user_mail
            tasarim.textViewPhoneNumber.text = user_phoneNumber*/
        }



        return tasarim.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


}