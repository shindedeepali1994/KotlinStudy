package com.example.favcountries.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.favcountries.data.CVS
import com.example.favcountries.data.CVData
import com.example.favcountries.repositories.CVDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class candidateModel(application: Application): AndroidViewModel(application) {
    val candi : LiveData<List<CVData>>
    val repository : CVDataRepository
    val profiles : LiveData<CVData>

    init {
        val dao = CVS.getInInstance(application).addDataDao()
        repository = CVDataRepository(dao)
        candi = repository.allCandidates
        profiles = repository.getProfile
    }

    fun addCV(cvData: CVData) = viewModelScope.launch(Dispatchers.IO) {
       repository.insert(cvData)
    }
}