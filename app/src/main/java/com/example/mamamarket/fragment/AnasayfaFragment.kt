package com.example.mamamarket.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.mamamarket.R
import com.example.mamamarket.UrunlerAdapter
import com.example.mamamarket.databinding.FragmentAnasayfaBinding
import com.example.mamamarket.entity.Product
import com.example.mamamarket.viewmodel.AnasayfaFragmentViewModel

class AnasayfaFragment : Fragment() {

    private lateinit var tasarim: FragmentAnasayfaBinding
    private lateinit var adapter: UrunlerAdapter
    private lateinit var urunlerListesi: ArrayList<Product>
    private lateinit var viewModel: AnasayfaFragmentViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)
        tasarim.anasayfaFragment = this
        //Fragment içinde viewModel tanımlaması
        val tempViewModel: AnasayfaFragmentViewModel by viewModels()
        this.viewModel = tempViewModel

        tasarim.toolbar.title = "Pet Mama Market"

      //  viewModel.urunleriYukle()



        viewModel.urunlerListesi.observe(viewLifecycleOwner, { urunlerListesi ->
            adapter = UrunlerAdapter(requireContext(), urunlerListesi, viewModel)
            tasarim.urunlerAdapter = adapter
            adapter.notifyDataSetChanged()
            Log.e("sadd", urunlerListesi.size.toString())
            Log.e("sadd", "buradaaa")

        })



        return tasarim.root
    }


}