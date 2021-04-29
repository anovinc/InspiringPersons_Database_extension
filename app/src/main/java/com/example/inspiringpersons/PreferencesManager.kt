package com.example.inspiringpersons

class PreferencesManager  {

    private val sharedPreferences= InspiringPersons.application.getSharedPreferences("firstTimeRunningApp",0)

    private val editor = sharedPreferences.edit()

    fun saveState(value : Boolean){
        editor.putBoolean("PREFS_KEY_VALUE",value)
        editor.commit()
    }

    fun getState():Boolean = sharedPreferences.getBoolean("PREFS_KEY_VALUE",false)

}