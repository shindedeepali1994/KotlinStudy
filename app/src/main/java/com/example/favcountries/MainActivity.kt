package com.example.favcountries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val arr = Array("Deepali",null,"Vishal")

        val recyclerView :RecyclerView = findViewById(R.id.countiesRecycler)
        val arrayList:ArrayList<Countries>? = ArrayList(5)

        arrayList?.add(Countries("India"))
        arrayList?.add(Countries("America"))
        arrayList?.add(Countries("Japan"))
        arrayList?.add(Countries("China"))

        //println("Array list "+arrayList + "ArraySize "+ (arrayList?.size ?: 0))

        recyclerView.layoutManager = LinearLayoutManager(this)
        val rAdapter = RecyclerAdapter(arrayList)
        recyclerView.adapter = rAdapter

    }
}