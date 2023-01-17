package com.mobapps.taskapp.model

import android.media.Rating

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class ProductDetailResponse (
    @SerializedName("id")
     val id: Int? = null,

    @SerializedName("title")
     val title: String? = null,

    @SerializedName("price")
     val price: Double? = null,

    @SerializedName("description")
     val description: String? = null,

    @SerializedName("category")
     val category: String? = null,

    @SerializedName("image")
     val image: String? = null,

    /*@SerializedName("rating")
    val rating: Rating? = null*/
)