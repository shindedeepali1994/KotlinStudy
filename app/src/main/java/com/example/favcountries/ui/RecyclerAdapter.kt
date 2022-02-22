package com.example.favcountries.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.favcountries.R
import com.example.favcountries.data.CVData
import com.example.favcountries.data.Utilities

class RecyclerAdapter(
    private val ctx:Context
    ) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val arrList=ArrayList<CVData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item_card,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = arrList?.get(position)
        holder.textV.text = item?.candidate?: "No Country found"

        holder.textV.setOnClickListener(){
            val int = Intent(ctx,ViewCV::class.java)
            val sharedPref = Utilities("Data",ctx)
            arrList?.get(position)
                ?.let { it1 -> sharedPref.CallPref("Profile", it1.candidate) }
            ctx.startActivity(int)

        }
    }

    override fun getItemCount(): Int {
        return arrList?.size ?: 0
    }

    fun updateList(newList:List<CVData>){
        arrList.clear()
        arrList.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewHolder(ItemV:View) : RecyclerView.ViewHolder(ItemV){
        val textV :TextView = ItemV.findViewById(R.id.countryName)
    }

}