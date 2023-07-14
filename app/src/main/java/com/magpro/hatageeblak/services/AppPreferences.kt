package com.magpro.hatageeblak.services

import android.content.Context
import android.content.SharedPreferences

open class AppPreferences(context: Context) {

    private val preferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        preferences = context.getSharedPreferences("compose_app_preferences",Context.MODE_PRIVATE)
        editor = preferences.edit()
    }

    fun set(key:String, value: Boolean){
        editor.putBoolean(key, value).commit()
    }

    fun set(key:String, value: Int){
        editor.putInt(key, value).commit()
    }

    fun set(key:String, value: String){
        editor.putString(key, value).commit()
    }

    fun getBoolean(key: String): Boolean{
        return preferences.getBoolean(key, false)
    }

    fun getInt(key: String): Int{
        return preferences.getInt(key, 0)
    }

    fun getString(key: String): String? {
        return preferences.getString(key, "null")
    }

}