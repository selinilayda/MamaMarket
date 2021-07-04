package com.example.mamamarket.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.mamamarket.MainActivity
import com.example.mamamarket.R
import com.example.mamamarket.SepetAdapter
import com.example.mamamarket.databinding.FragmentSepetBinding
import com.example.mamamarket.entity.Product
import com.example.mamamarket.viewmodel.SepetFragmentViewModel


class SepetFragment : Fragment() {


    private lateinit var viewModel: SepetFragmentViewModel
    private lateinit var tasarim : FragmentSepetBinding
    private lateinit var adapter: SepetAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet, container, false)

        tasarim.sepetFragment = this
        tasarim.toolbar.title = "Pet Mama Market"


        //Fragment içinde viewModel tanımlaması
        val tempViewModel: SepetFragmentViewModel by viewModels()
        this.viewModel = tempViewModel


        viewModel.sepetUrunListesi.observe(viewLifecycleOwner,{sepetListesi->

            Log.e("sepetListesi",sepetListesi.toString())
            adapter = SepetAdapter(requireContext(), sepetListesi,viewModel)
            tasarim.sepetAdapter = adapter
            adapter.notifyDataSetChanged()

        })





        return tasarim.root
    }

}