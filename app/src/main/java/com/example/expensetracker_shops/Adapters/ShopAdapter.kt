package com.example.expensetracker_shops.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expensetracker_shops.Models.ShopModel
import com.example.expensetracker_shops.R
import java.text.FieldPosition

class ShopAdapter (private val shopList:ArrayList<ShopModel>) :
    RecyclerView.Adapter<ShopAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType :Int):ShopAdapter.ViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.shop_list_item, parent
        , false)
        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder:ShopAdapter.ViewHolder, position: Int) {
        val currentShop = shopList[position]
        holder.tvShopName.text = currentShop.shopName
    }

    override fun getItemCount(): Int {
        return shopList.size
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val tvShopName : TextView = itemView.findViewById(R.id.tvShopName)
    }


}