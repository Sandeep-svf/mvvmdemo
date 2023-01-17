package com.mobapps.taskapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobapps.taskapp.adapter.ProductListAdapter
import com.mobapps.taskapp.model.ProductListModel
import com.mobapps.taskapp.viewmodel.ProductListViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ProductListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       viewModel = ViewModelProvider(this).get(ProductListViewModel::class.java)

        val recyclerview = findViewById<RecyclerView>(R.id.productsList_recyclerview)
        val servicesLayoutManager: RecyclerView.LayoutManager =
            GridLayoutManager(this@MainActivity, 2)
        recyclerview.setLayoutManager(servicesLayoutManager)
       // recyclerview.addItemDecoration(GridSpacingItemDecoration(2, dpToPx(5), true))
        recyclerview.setItemAnimator(DefaultItemAnimator())
        viewModel.getProdList().observe(this, Observer {

            it?.let {
                val productListAdapter = ProductListAdapter(it){productListModel ->
                    Log.e("chk_size","        "+productListModel?.id)
                    intent = Intent(this@MainActivity, ProductDetail::class.java)
                    intent.putExtra("product_id",productListModel?.id)
                    startActivity(intent)
                }
                recyclerview.adapter = productListAdapter
            }

        })

        viewModel.errorMessage.observe(this, Observer {

            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()

        })

    }
}