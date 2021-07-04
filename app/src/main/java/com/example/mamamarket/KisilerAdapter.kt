/*package com.example.mamamarket

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.mamamarket.databinding.CardTasarimBinding
import com.example.mamamarket.entity.Users
import com.example.mamamarket.fragment.AnasayfaFragmentDirections
import com.example.mamamarket.viewmodel.AnasayfaFragmentViewModel
import com.example.mamamarket.viewmodel.KayitOlFragmentViewModel
import com.example.mamamarket.viewmodel.LoginFragmentViewModel
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext: Context, var kisilerListesi:List<Users>, var viewModel: LoginFragmentViewModel)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu (cardTasarimBinding: CardTasarimBinding)
        : RecyclerView.ViewHolder(cardTasarimBinding.root){

        var cardTasarim: CardTasarimBinding

        init{
            this.cardTasarim = cardTasarimBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi.get(position)


        holder.cardTasarim.kisiNesnesi = kisi

        holder.cardTasarim.satirCard.setOnClickListener {
            //Toast.makeText(mContext,"${kisi.kisi_ad} seçildi", Toast.LENGTH_SHORT).show()

            val gecis = AnasayfaFragmentDirections.detayGecis(kisi)

            Navigation.findNavController(it).navigate(gecis)
        }


    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }




}*/