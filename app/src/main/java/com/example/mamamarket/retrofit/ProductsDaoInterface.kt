package com.example.mamamarket.retrofit

import com.example.mamamarket.entity.CRUDResponse
import com.example.mamamarket.entity.Product
import com.example.mamamarket.entity.ProductResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ProductsDaoInterface {
    @POST("urunler.php")
    @FormUrlEncoded
    fun tumUrunler(
        @Field("satici_adi") satici_adi: String,
    ): Call<ProductResponse>

    @POST("urun_ekle.php")
    @FormUrlEncoded
    fun urunEkle(
        @Field("satici_adi") satici_adi: String,
        @Field("urun_adi") urun_adi: String,
        @Field("urun_fiyat") urun_fiyat: String,
        @Field("urun_aciklama") urun_aciklama: String,
        @Field("urun_gorsel_url") urun_gorsel_url: String,


    ): Call<CRUDResponse>

    @POST("sepet_durum_degistir.php")
    @FormUrlEncoded
    fun sepetDurumDegistir(
        @Field("id") id: Int,
        @Field("sepet_durum") sepet_durum:Int
    ): Call<CRUDResponse>

    @POST("indirimli_urun_durum_degistir.php")
    @FormUrlEncoded
    fun promosyonluUrun(
        @Field("id") id:Int,
        @Field("urun_indirimli_mi") urun_indirimli_mi: Int):Call<CRUDResponse>



}