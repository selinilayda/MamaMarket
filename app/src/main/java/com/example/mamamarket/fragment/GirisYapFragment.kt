package com.example.mamamarket.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.mamamarket.MainActivity
import com.example.mamamarket.R
import com.example.mamamarket.databinding.FragmentGirisYapBinding
import com.example.mamamarket.viewmodel.LoginFragmentViewModel

class GirisYapFragment : Fragment() {

    private lateinit var tasarim: FragmentGirisYapBinding

    //private lateinit var adapter: KisilerAdapter
    private lateinit var viewModel: LoginFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_giris_yap, container, false)
        tasarim.loginFragment = this
        tasarim.toolbarKisiKayit.title = "Pet Mama Market"

        //viewModel.kisilerListesi.observe(viewLifecycleOwner) {

        //}//{ kisilerListesi ->
        //adapter = KisilerAdapter(requireContext(),kisilerListesi,viewModel)
        //tasarim.adapter = adapter

        //}

        val temp: LoginFragmentViewModel by viewModels()
        viewModel = temp
        activity?.let { itActivity ->
            val preferences =
                itActivity.getSharedPreferences("com.example.mamamarket", Context.MODE_PRIVATE)
            val editor = preferences!!.edit()

            try {
                viewModel.kisilerListesi.observe(viewLifecycleOwner, {
                    if (it[0].user_id == 1) {
                        editor.putString("user_mail", it[0].user_mail)
                        editor.putString("user_fullName", it[0].user_fullName)
                        editor.putString("user_phoneNumber", it[0].user_phoneNumber)
                        editor.commit()

                        val intent = Intent(itActivity, MainActivity::class.java)
                        itActivity.startActivity(intent)

                    } else {
                        Toast.makeText(context, "Hatalı mail veya şifre, tekrar dene !", Toast.LENGTH_SHORT).show()
                    }
                })

            } catch (e: Exception) {

            }

        }

        tasarim.buttonKaydet.setOnClickListener {
            val mail = tasarim.editTextKisiEmail.text.toString()
            val sifre = tasarim.editTextKisiSifre.text.toString()
            activity?.let {
                loginButton(it, mail, sifre)
            }

        }

        return tasarim.root
    }


    fun loginButton(myContext: Context, user_mail: String, user_password: String) {
        viewModel.oturumAc(myContext, user_mail, user_password)


    }

    fun uyeOlSayfaGecis() {

        //val gecis = GirisYapFragmentDirections.actionGirisYapFragmentToKayitOlFragment()
        //    Navigation.findNavController().navigate(gecis)

        //   Navigation.findNavController(tasarim.buttonKaydet).navigate(gecis)

        activity?.let {
            val transaction = it.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment, KayitOlFragment())
            transaction.commit()

        }

    }


}