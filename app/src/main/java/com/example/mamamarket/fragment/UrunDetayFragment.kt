package com.example.mamamarket.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.mamamarket.MainActivity
import com.example.mamamarket.R
import com.example.mamamarket.databinding.FragmentUrunDetayBinding
import com.example.mamamarket.repo.ProductsDaoRepository
import com.example.mamamarket.retrofit.ApiUtils
import com.example.mamamarket.retrofit.ProductsDaoInterface
import com.example.mamamarket.viewmodel.UrunDetayFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class UrunDetayFragment : Fragment() {
    private lateinit var viewModel: UrunDetayFragmentViewModel
    private lateinit var tasarim: FragmentUrunDetayBinding

    val pdaor: ProductsDaoRepository = ProductsDaoRepository()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_urun_detay, container, false)
        tasarim.toolbar3.title = "Pet Mama Market"


        val bundle: UrunDetayFragmentArgs by navArgs()
        var gelenUrun = bundle.urun

        var url = gelenUrun.urun_gorsel_url
        var id = tasarim.imageViewDetay

        Log.e("sadd", gelenUrun.toString())



        Picasso.get().load(url).into(id)

        tasarim.urunNesnesi = gelenUrun

        tasarim.buttonSepeteEkle.setOnClickListener {
            Snackbar.make(it, "${gelenUrun.urun_adi} sepete eklendi!", Snackbar.LENGTH_SHORT).show()
            // ((activity as MainActivity)).getArray().add(bundle.urun)
            pdaor.sepetDurumGuncelle(gelenUrun.product_id,1)

            activity?.let {


/*
                val transaction = it. supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment, AnasayfaFragment()).isAddToBackStackAllowed

                transaction.commit()*/
            }


        }



        return tasarim.root
    }



}