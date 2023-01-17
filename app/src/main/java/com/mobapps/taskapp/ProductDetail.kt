package com.mobapps.taskapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobapps.taskapp.adapter.ProductListAdapter
import com.mobapps.taskapp.viewmodel.ProductDetailViewModel
import com.mobapps.taskapp.viewmodel.ProductListViewModel

class ProductDetail : AppCompatActivity() {
    lateinit var viewModel: ProductDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        var Intent1: Intent
        Intent1= getIntent()

        var id :Int  =  Intent1.getIntExtra("product_id",0);
        var product_title = findViewById<TextView>(R.id.productNameTxt)
        var product_price = findViewById<TextView>(R.id.priceTxt)
        var product_image = findViewById<ImageView>(R.id.productImage)
        var product_category = findViewById<TextView>(R.id.prod_catgory)
        var product_description = findViewById<TextView>(R.id.descriptionTxt)
        var back = findViewById<LinearLayout>(R.id.back_arrow_button)
        val button = findViewById<Button>(R.id.update_detail)

        viewModel = ViewModelProvider(this).get(ProductDetailViewModel::class.java)
        viewModel.getProdDetail(id.toString())
        viewModel.productdetail.observe(this, Observer {
            product_title.text=it?.title
            product_price.text= "$"+it?.price.toString()
            product_category.text=it?.category
            product_description.text=it?.description
            Glide.with(this).load(it.image)
                .thumbnail(0.5f)
                .into(product_image)
        })

        viewModel.errorMessage.observe(this, Observer {

            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()

        })

        button.setOnClickListener(){
            startActivity(Intent(this, EditDetailActivity::class.java))
        }

        back.setOnClickListener{
            finish()
        }
    }
}