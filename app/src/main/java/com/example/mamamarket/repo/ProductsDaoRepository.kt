package com.example.mamamarket.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mamamarket.entity.CRUDResponse
import com.example.mamamarket.entity.Product
import com.example.mamamarket.entity.ProductResponse
import com.example.mamamarket.entity.Users
import com.example.mamamarket.retrofit.ApiUtils
import com.example.mamamarket.retrofit.ProductsDaoInterface
import com.example.mamamarket.retrofit.UsersDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsDaoRepository {
    private val urunlerListesi: MutableLiveData<List<Product>> = MutableLiveData()
    private val sepetUrunListesi: MutableLiveData<List<Product>> = MutableLiveData()
    private val kampanyaUrunListesi: MutableLiveData<List<Product>> = MutableLiveData()
    private val pdaoi: ProductsDaoInterface = ApiUtils.getProductsDaoInterface()




    fun tumUrunleriAl() {
        pdaoi.tumUrunler("selinilaydakarabulut").enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>?, response: Response<ProductResponse>?) {


                val urun = response?.body()?.urunler
                urunlerListesi.value = urun

                Log.e("urunListesi", urun?.size.toString())


            }

            override fun onFailure(call: Call<ProductResponse>?, t: Throwable?) {}
        })


    }

    fun urunleriAl(): MutableLiveData<List<Product>> {
        return urunlerListesi
    }

    fun urunlerEkle(satici_adi: String, urun_adi: String, urun_fiyat: String, urun_aciklama: String, urun_gorsel_url: String) {

        pdaoi.urunEkle(satici_adi, urun_adi, urun_fiyat, urun_aciklama, urun_gorsel_url)
            .enqueue(object : Callback<CRUDResponse> {
                override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>) {
                    Log.e("Başarı", response.body()?.success.toString())
                    Log.e("Mesaj", response.body()!!.message)

                    //val liste = response.body().message
                    //urunlerListesi.value = liste
                }

                override fun onFailure(call: Call<CRUDResponse>?, t: Throwable) {
                    println(t?.localizedMessage.toString())
                }
            })


    }


    /*  fun urunGetir(satici_adi: String){
          pdaoi.tumUrunler(satici_adi).enqueue(object :Callback<ProductResponse>{
              override fun onResponse(
                  call: Call<ProductResponse>,
                  response: Response<ProductResponse>
              ) {
                  val urunlerList= response?.body()?.urunler


              }

              override fun onFailure(call: Call<ProductResponse>, t: Throwable?) {

              }
          })
      }*/
    fun kampanyaDurumGuncelle(id: Int, kampanya_durum: Int) {
        pdaoi.promosyonluUrun(id, kampanya_durum).enqueue(object : Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                Log.e("Başarılı Kampanya", response.body()!!.message)

            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {
                Log.e("Başarılı Kampanya", t.localizedMessage.toString())

            }

        })
    }

    fun kampanyaliUrunleriAl() {
        pdaoi.tumUrunler("selinilaydakarabulut").enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {

                if (response.isSuccessful) {
                    val liste = response?.body()!!.urunler

                    val tempList = arrayListOf<Product>()
                    for (i in liste) {
                        if (i.urun_indirimli_mi == 1) {
                            tempList.add(i)
                        }
                    }
                    kampanyaUrunListesi.value = tempList
                    Log.e("kampanya urun al repo", kampanyaUrunListesi.value?.size.toString())
                }


            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
            }


        })
    }


    fun kampanyaliUrunListAl(): MutableLiveData<List<Product>> {
        Log.e("kampanyaurunal repoList", kampanyaUrunListesi.value?.size.toString())
        return kampanyaUrunListesi


    }


    fun sepetDurumGuncelle(id: Int, sepet_durum: Int) {
        pdaoi.sepetDurumDegistir(id, sepet_durum).enqueue(object : Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                Log.e("Başarılı", response.body()!!.message)

            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {
                Log.e("Başarılı", t.localizedMessage.toString())

            }

        })
    }


    fun sepettekiTumUrunleriAl() {
        pdaoi.tumUrunler("selinilaydakarabulut").enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                val liste = response?.body()!!.urunler

                val tempList = arrayListOf<Product>()
                for (i in liste) {
                    if (i.sepet_durum == 1) {
                        tempList.add(i)
                    }
                }
                sepetUrunListesi.value = tempList
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
            }

        })
    }

    fun sepetUrunListGetir(): MutableLiveData<List<Product>> {
        return sepetUrunListesi
    }


}
