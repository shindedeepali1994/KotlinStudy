package com.example.favcountries.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CVData::class],version = 1)
abstract class CVS : RoomDatabase() {
    abstract fun addDataDao(): AddDataDao

    companion object {

        var INSTANCE: CVS? = null
        fun getInInstance(context:Context): CVS
        {
            if(INSTANCE ==null)
            {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    CVS::class.java, "CVS.db")
                    .build()
            }
            return INSTANCE!!
        }
    }
}
