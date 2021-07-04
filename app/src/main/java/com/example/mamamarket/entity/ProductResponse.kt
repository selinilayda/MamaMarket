package com.example.mamamarket.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductResponse (
    @SerializedName("urunler")
    @Expose
    var urunler: List<Product>,
    @SerializedName("success")
    @Expose
    var success: Int
    ){
}