package com.example.favcountries.data

import android.content.Context

class Utilities(prefNm:String,mCtx:Context) {

    val sharedPreference = mCtx.getSharedPreferences(prefNm, Context.MODE_PRIVATE)
    fun CallPref(ke:String, value:String) {
        //val sharedPreference = mCtx.getSharedPreferences(prefNm, Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.putString(ke, value)
        editor.commit()
    }

    fun getValues(key:String): String? {
        return sharedPreference.getString(key,"No Profile selected")
    }
}