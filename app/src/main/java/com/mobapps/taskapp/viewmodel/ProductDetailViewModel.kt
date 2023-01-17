package com.mobapps.taskapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobapps.taskapp.Repo.ProductListRepository
import com.mobapps.taskapp.model.ProductDetailResponse
import com.mobapps.taskapp.model.ProductListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailViewModel : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val productdetail = MutableLiveData<ProductDetailResponse>()
    val productRepo: ProductListRepository = ProductListRepository()

    fun getProdDetail(id: String){

        val response = productRepo.getProductDetail(id)

        response?.enqueue(object : Callback<ProductDetailResponse> {
            override fun onResponse(call: Call<ProductDetailResponse>, response: Response<ProductDetailResponse>) {
                Log.e("product ","dd ")
                productdetail.postValue(response.body())
            }
            override fun onFailure(call: Call<ProductDetailResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
                Log.e("product ","errr "+t.message)
            }
        })

    }
}