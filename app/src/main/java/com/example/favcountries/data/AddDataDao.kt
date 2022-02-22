package com.example.favcountries.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.favcountries.data.CVData

@Dao
interface AddDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCV(todo: CVData):Long

    @Query("SELECT * FROM Profile")
    fun getAll(): List<CVData>

    @Query("select * from Profile where Candidate = :profileName")
    fun getCV(profileName:String): CVData

    @Query("select * from Profile where Candidate = :profileName")
    fun getProfile(profileName:String): LiveData<CVData>

    @Query("SELECT * FROM Profile") //this is for list of candidates-working
    fun getAllCandidates(): LiveData<List<CVData>>

    @Query("select * from Profile where id = :recordID")
    fun viewCV(recordID:Long): CVData

}