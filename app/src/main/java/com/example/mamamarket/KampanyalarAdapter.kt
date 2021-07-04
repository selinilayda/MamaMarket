package com.example.mamamarket

import android.content.Context
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mamamarket.databinding.CardTasarimBinding

import com.example.mamamarket.entity.Product

import com.example.mamamarket.viewmodel.KampanyalarFragmentViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.kampanya_card_tasarim.view.*

class KampanyalarAdapter(var mContext: Context, var urunlerListesi: List<Product>, var viewModel: KampanyalarFragmentViewModel) : RecyclerView.Adapter<KampanyalarAdapter.CardTasarimTutucu>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KampanyalarAdapter.CardTasarimTutucu {
        val view = LayoutInflater.from(mContext).inflate(R.layout.kampanya_card_tasarim, parent, false)
        Log.e("kampanya adater ici", urunlerListesi.size.toString())

        return CardTasarimTutucu(view)
    }

    override fun onBindViewHolder(holder: KampanyalarAdapter.CardTasarimTutucu, position: Int) {
        val item = urunlerListesi[position]

        holder.itemView.textViewCardSepetYemekAdi.text = item.urun_adi
        holder.itemView.textViewSepetYemekFiyat.text = item.urun_fiyat.toString() + " tl"

        Picasso.get().load(item.urun_gorsel_url).into(holder.itemView.imageViewSepetResim)

    }

    override fun getItemCount(): Int {
        return urunlerListesi.size
    }

    inner class CardTasarimTutucu(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}