package com.mobapps.taskapp.Repo

import com.mobapps.taskapp.model.ProductDetailResponse
import com.mobapps.taskapp.model.ProductListModel
import com.mobapps.taskapp.retrofit.ApiClient
import retrofit2.Call

class ProductListRepository {
    val apiInterface = ApiClient.getRetrofitService()
    fun getProductList(): Call<ArrayList<ProductListModel>>? {

        return apiInterface?.getproductlist()
    }

    fun getProductDetail(id: String): Call<ProductDetailResponse>? {
       // var map = HashMap<String,String>()
      //  map.put("i",id)
        return apiInterface?.getproductDetail(id)
    }

}