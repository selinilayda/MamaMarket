package com.example.mamamarket.repo

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.mamamarket.MainActivity
import com.example.mamamarket.entity.*
import com.example.mamamarket.retrofit.ApiUtils
import com.example.mamamarket.retrofit.UsersDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersDaoRepository {

    private var kullanıcıBilgisi = MutableLiveData<Users>()
    private val udaoi: UsersDaoInterface
    private val kisilerListesi: MutableLiveData<List<Users>>
    lateinit var users: Users

    init {
        udaoi = ApiUtils.getUsersDaoInterface()
        kisilerListesi = MutableLiveData()
    }


    fun kayit(
        myContext: Context,
        user_mail: String,
        user_password: String,
        user_fullName: String,
        user_phoneNumber: String
    ) {
        udaoi.uye_ol(user_mail, user_password, user_fullName, user_phoneNumber)
            .enqueue(object : Callback<CRUDResponse> {
                override fun onResponse(
                    call: Call<CRUDResponse>?,
                    response: Response<CRUDResponse>?
                ) {
                    if (response != null) {
                        if (response.isSuccessful) {

                            Toast.makeText(myContext, "Başarılı bir şekilde kayıt yapıldı.", Toast.LENGTH_LONG).show()

                            myContext?.let {
                                val preferences = it.getSharedPreferences("com.example.mamamarket", Context.MODE_PRIVATE)
                                val editor = preferences!!.edit()

                                editor.putString("user_mail", user_mail)
                                editor.putString("user_fullName", user_fullName)
                                editor.putString("user_phoneNumber", user_phoneNumber)
                                editor.commit()
                            }

                        }


                    } else Log.e("Kayit", "response null")
                    Log.e("Kayit", response.toString())

                }

                override fun onFailure(call: Call<CRUDResponse>?, t: Throwable) {
                    Log.e("Kayit", t.message.toString())

                }

            })


    }

    fun oturumAc(myContext: Context, user_mail: String, user_password: String) {
        udaoi.giris_yap(user_mail, user_password).enqueue(object : Callback<UsersResponse> {
            override fun onResponse(
                call: Call<UsersResponse>?,
                response: Response<UsersResponse>?
            ) {


                val users = response!!.body()!!.user
                //  kisilerListesi.value = users


                Log.e("giris", users.toString())


                if (!users.isNullOrEmpty()) {
                    val intent = Intent(myContext, MainActivity::class.java)
                    myContext.startActivity(intent)
                }

                Log.e("girisListe", kisilerListesi.value?.size.toString())
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {}
        })
    }

    fun kisileriGetir(): MutableLiveData<List<Users>> {
        return kisilerListesi
    }

/*
    fun kisiBilgileriAl() {
        udaoi.uye_ol("selinilaydakarabulut").enqueue(object : Callback<ProductResponse> {
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

    fun kisiAl(): Users {
        return users
    }*/


}
