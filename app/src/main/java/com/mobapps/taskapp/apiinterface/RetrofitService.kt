package com.mobapps.taskapp.apiinterface

import com.mobapps.taskapp.model.ProductDetailResponse
import com.mobapps.taskapp.model.ProductListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("products")
    fun getproductlist(): Call<ArrayList<ProductListModel>>?

    @GET("products/{id}")
    fun getproductDetail(@Path("id") id: String): Call<ProductDetailResponse>?
}