package com.example.favcountries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.favcountries.R
import com.example.favcountries.data.CVData
import com.example.favcountries.data.Utilities
import com.example.favcountries.viewmodel.candidateModel

class ViewCV : AppCompatActivity(){

    lateinit var candidateTxt: TextView
    lateinit var objectiveTxt: TextView
    lateinit var skillsTxt : TextView
    lateinit var expTxt : TextView
    lateinit var educationTxt: TextView
    lateinit var projectTxt: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_cv)

        val viewModel :candidateModel

        val pref = Utilities("Data",this)

        candidateTxt = findViewById(R.id.profileNameTxt)
        objectiveTxt = findViewById(R.id.objectivesTxt)
        skillsTxt = findViewById(R.id.skillsText)
        expTxt = findViewById(R.id.ExperienceTxt)
        educationTxt = findViewById(R.id.educationTxt)
        projectTxt = findViewById(R.id.projectsTxt)

        viewModel= ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(candidateModel::class.java)

        pref.getValues("Profile")
            ?.let { viewModel.getProfileData(it).observe(this,{ list->list.let { updateUI(it) }}) }

    }
    fun updateUI(cv:CVData){
        candidateTxt.setText("Candidate Name : "+cv!!.candidate)
        objectiveTxt.setText("Objective : "+cv.objective)
        skillsTxt.setText("Skills : "+cv.skills)
        expTxt.setText("Past experience : "+cv.experience)
        educationTxt.setText("Education : "+cv.education)
        projectTxt.setText("Projects : "+cv.projects)
    }
}