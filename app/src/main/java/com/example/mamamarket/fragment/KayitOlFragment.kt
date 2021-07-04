package com.example.mamamarket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.mamamarket.R
import com.example.mamamarket.databinding.FragmentKayitOlBinding
import com.example.mamamarket.viewmodel.KayitOlFragmentViewModel


class KayitOlFragment : Fragment() {


    private lateinit var tasarim: FragmentKayitOlBinding
    private lateinit var viewModel: KayitOlFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_kayit_ol, container, false)

        tasarim.kayitOlFragment = this
        tasarim.kayitOlToolbarBaslik = "Pet Mama Market"


        tasarim.buttonKaydet.setOnClickListener {

            val email = tasarim.editTextKisiEmail.text.toString()
            val sifre = tasarim.editTextKisiSifre.text.toString()
            val ad = tasarim.editTextKisiAd.text.toString()
            val tel = tasarim.editTextKisiTel.text.toString()

            buttonKaydet(
                user_mail = email,
                user_password = sifre,
                user_fullName = ad,
                user_phoneNumber = tel
            )

        }

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: KayitOlFragmentViewModel by viewModels()
        viewModel = temp
    }

    fun buttonKaydet(
        user_mail: String,
        user_password: String,
        user_fullName: String,
        user_phoneNumber: String
    ) {
        activity?.let {
            viewModel.kayit(it,user_mail, user_password, user_fullName, user_phoneNumber)

        }


/*
        val gecis = KayitOlFragmentDirections.actionKayitOlFragmentToGirisYapFragment()
        Navigation.findNavController(requireView()).navigate(gecis)
*/

        activity?.let {
            val transaction = it.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment, GirisYapFragment())
            transaction.commit()

        }

    }
}