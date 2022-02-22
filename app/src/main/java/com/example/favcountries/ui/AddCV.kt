package com.example.favcountries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.favcountries.data.CVData
import com.example.favcountries.R
import com.example.favcountries.viewmodel.candidateModel

class AddCV : AppCompatActivity() {
    lateinit var candidateTxt:EditText
    lateinit var objectiveTxt:EditText
    lateinit var skillsTxt :EditText
    lateinit var expTxt :EditText
    lateinit var educationTxt:EditText
    lateinit var projectTxt:EditText
   // var recordID:Long = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_cv)
        val addCandidateBtn : Button = findViewById(R.id.submit)
       // var viewCV : Button = findViewById(R.id.viewCV)

        val viewModel:candidateModel

        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(candidateModel::class.java)

        candidateTxt = findViewById(R.id.candidateTxt)
        objectiveTxt = findViewById(R.id.objectiveText)
        skillsTxt = findViewById(R.id.skillsText)
        expTxt = findViewById(R.id.expTst)
        educationTxt = findViewById(R.id.educationText)
        projectTxt = findViewById(R.id.projectsTxt)

        var candidate:String?=null
        var objective:String?=null
        var skills:String?=null
        var education:String?=null
        var experience:String?=null
        var projects:String?=null

        addCandidateBtn.setOnClickListener {

            println("Submit button clicked")
            candidate = candidateTxt.text.toString()
            objective = objectiveTxt.text.toString()
            skills = skillsTxt.text.toString()
            experience = expTxt.text.toString()
            education = educationTxt.text.toString()
            projects = projectTxt.text.toString()

            if(Validate(candidateTxt)&& Validate(objectiveTxt)&&Validate(skillsTxt)&&Validate(expTxt)&&Validate(educationTxt)&&Validate(projectTxt)){
                val info = CVData( null, candidate!!, objective!!, skills!!, experience!!,education!!, projects!!)
                println(info)

                viewModel.addCV(info) //Insert CV to database

                ClearFields()//This clears all fileds post submission

            }else{Toast.makeText(this,"All fields are mandatory",Toast.LENGTH_LONG).show()}
        }
    }

    private fun ClearFields(){
        candidateTxt.text.clear()
        objectiveTxt.text.clear()
        skillsTxt.text.clear()
        expTxt.text.clear()
        educationTxt.text.clear()
        projectTxt.text.clear()
    } //Clear fields

    private fun Validate(editTxt:EditText):Boolean{
        var check:Boolean = false
        if(editTxt.text.toString().trim().length>0) check = true
        return check
    } //Validate fiels

}



