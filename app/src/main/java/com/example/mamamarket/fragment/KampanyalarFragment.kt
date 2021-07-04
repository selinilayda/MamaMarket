package com.example.mamamarket.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels

import com.example.mamamarket.KampanyalarAdapter
import com.example.mamamarket.R
import com.example.mamamarket.databinding.FragmentKampanyalarBinding
import com.example.mamamarket.viewmodel.KampanyalarFragmentViewModel


class KampanyalarFragment : Fragment() {

    private lateinit var tasarim : FragmentKampanyalarBinding
    private lateinit var adapter: KampanyalarAdapter
    private lateinit var viewModel: KampanyalarFragmentViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_kampanyalar, container, false)
        tasarim.kampanyalarFragment = this

        //Fragment içinde viewModel tanımlaması
        val tempViewModel: KampanyalarFragmentViewModel by viewModels()
        this.viewModel = tempViewModel

        tasarim.toolbar2.title = "Pet Mama Market"

        //   ProductsDaoRepository().kampanyaDurumGuncelle(746,1)
     //   ProductsDaoRepository().kampanyaDurumGuncelle(764,1)
      //  ProductsDaoRepository().kampanyaDurumGuncelle(754,1)

        viewModel.kampanyaliUrunlerListesi.observe(viewLifecycleOwner, { urunlerListesi ->

            adapter = KampanyalarAdapter(requireContext(), urunlerListesi,viewModel)
            tasarim.kampanyalarAdapter = adapter
            adapter.notifyDataSetChanged()

        })

        return tasarim.root
    }



}


