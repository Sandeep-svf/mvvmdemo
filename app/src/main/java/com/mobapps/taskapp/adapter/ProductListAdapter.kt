package com.mobapps.taskapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobapps.taskapp.ProductDetail
import com.mobapps.taskapp.R
import com.mobapps.taskapp.model.ProductListModel

class ProductListAdapter(var productList: List<ProductListModel?>?, var itemOnClick:(ProductListModel?)->Unit) : RecyclerView.Adapter<ProductListAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_adapter, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {


        productList?.let {
            holder.bind(it.get(position))
        }

    }
    override fun getItemCount(): Int {
        return productList?.size?:0
    }

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView){

        var title : TextView= itemView.findViewById(R.id.productNametxt)
        var price : TextView= itemView.findViewById(R.id.priceTxt)
        var image : ImageView= itemView.findViewById(R.id.productImage)

        fun bind(item:ProductListModel?){
            title.text=item?.title
            price.text= "$"+item?.price.toString()
            Glide.with(itemView.context).load(item?.image)
                .thumbnail(0.5f)
                .into(image)
            itemView.setOnClickListener{
                item?.let {
                    itemOnClick(item)
                }

               // context.startActivity(Intent(context, ProductDetail::class.java))
            }
        }
    }
}