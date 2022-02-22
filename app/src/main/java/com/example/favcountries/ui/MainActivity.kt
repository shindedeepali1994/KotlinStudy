package com.example.favcountries.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.favcountries.*
import com.example.favcountries.data.CVData
import com.example.favcountries.viewmodel.candidateModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel:candidateModel
        var rAdapter: RecyclerAdapter
        val recyclerView :RecyclerView = findViewById(R.id.countiesRecycler)
        val addCV : Button= findViewById(R.id.addUser)

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        rAdapter = RecyclerAdapter(this@MainActivity)
        recyclerView.adapter = rAdapter

        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(candidateModel::class.java)
        viewModel.candi.observe(this, Observer { list -> list.let { rAdapter.updateList(it) } })

        addCV.setOnClickListener(){
            val addCandidateCV:Intent = Intent(this, AddCV::class.java)
            startActivity(addCandidateCV)
        }
    }
}