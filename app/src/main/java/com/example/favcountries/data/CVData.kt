package com.example.favcountries.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Profile")
data class CVData(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "Candidate") val candidate: String,
    @ColumnInfo(name = "Objective") val objective: String,
    @ColumnInfo(name = "Skills") val skills: String,
    @ColumnInfo(name = "Experience") val experience: String,
    @ColumnInfo(name = "Education") val education: String,
    @ColumnInfo(name = "Projects") val projects: String
)
