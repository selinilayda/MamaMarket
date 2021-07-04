package com.example.mamamarket

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.mamamarket.entity.Product
import com.example.mamamarket.fragment.AnasayfaFragmentDirections
import com.example.mamamarket.viewmodel.AnasayfaFragmentViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_tasarim.view.*

class UrunlerAdapter(var mContext: Context, var urunlerListesi: List<Product>, var viewModel: AnasayfaFragmentViewModel) : RecyclerView.Adapter<UrunlerAdapter.CardTasarimTutucu>() {

    /*   inner class CardTasarimTutucu(cardTasarimBinding: View) :
           RecyclerView.ViewHolder(cardTasarimBinding.root) {
           val cardTasarim: CardTasarimBinding = cardTasarimBinding

       }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val view = LayoutInflater.from(mContext).inflate(R.layout.card_tasarim, parent, false)


        return CardTasarimTutucu(view)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val urun = urunlerListesi[position]
        // val t = holder.cardTasarim
        Log.e("sadddAdapter", urunlerListesi.size.toString())
        //  t.urunNesnesi = urun


        //    var id = holder.cardTasarim.imageViewCardResim
        Picasso.get().load(urun.urun_gorsel_url).into(holder.itemView.imageViewCardResim)

        holder.itemView.textViewCardUrunAd.text = urun.urun_adi.toString()
        holder.itemView.textViewCardUrunFiyat.text = urun.urun_fiyat.toString()

        holder.itemView.urun_card.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayaGecis(urun)
            Navigation.findNavController(it).navigate(gecis)
        }


    }

    override fun getItemCount(): Int {
        return urunlerListesi.size
    }


    inner class CardTasarimTutucu(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}