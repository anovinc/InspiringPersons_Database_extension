package com.example.inspiringpersons

import android.app.Application

class InspiringPersons : Application(){
    companion object{
        lateinit var application: InspiringPersons
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}