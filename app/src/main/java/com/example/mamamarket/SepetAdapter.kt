package com.example.mamamarket

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.mamamarket.databinding.SepetCardTasarimBinding
import com.example.mamamarket.entity.Product
import com.example.mamamarket.repo.ProductsDaoRepository
import com.example.mamamarket.viewmodel.SepetFragmentViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.sepet_card_tasarim.view.*

class SepetAdapter(var mContext: Context, var sepetListesi:List<Product>, var viewModel: SepetFragmentViewModel)
    : RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(cardTasarimBinding: SepetCardTasarimBinding) :
        RecyclerView.ViewHolder(cardTasarimBinding.root) {
        val sepetCardTasarim: SepetCardTasarimBinding = cardTasarimBinding

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = SepetCardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val sepet = sepetListesi.get(position)
        val t = holder.sepetCardTasarim

        t.urunNesnesi = sepet

        var image=holder.sepetCardTasarim.imageViewSepetResim
        Picasso.get().load(sepet.urun_gorsel_url).into(image)

        t.imageViewCopKutusu.setOnClickListener {
             val pdaoi = ProductsDaoRepository()
            pdaoi.sepetDurumGuncelle(sepet.product_id,0)

        }



    }

    override fun getItemCount(): Int {
        return sepetListesi.size
    }


}