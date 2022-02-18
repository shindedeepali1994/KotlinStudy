package com.example.favcountries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val arrList:ArrayList<Countries>?) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item_card,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = arrList?.get(position)
        holder.textV.text = item?.name?: "No Country found"
    }

    override fun getItemCount(): Int {
        return arrList?.size ?: 0
    }

    class ViewHolder(ItemV:View) : RecyclerView.ViewHolder(ItemV){
        val textV :TextView = ItemV.findViewById(R.id.countryName)
    }

}