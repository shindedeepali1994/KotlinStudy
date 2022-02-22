package com.example.favcountries.repositories

import androidx.lifecycle.LiveData
import com.example.favcountries.data.AddDataDao
import com.example.favcountries.data.CVData

class CVDataRepository(private val dataDao: AddDataDao) {
    val allCandidates:LiveData<List<CVData>> = dataDao.getAllCandidates()
    val getProfile:LiveData<CVData> = dataDao.getProfile("Deepali Shinde")
    suspend fun insert(cvData: CVData) {
     dataDao.insertCV(cvData)
    }
}