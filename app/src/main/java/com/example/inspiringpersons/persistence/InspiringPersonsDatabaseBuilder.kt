package com.example.inspiringpersons.persistence

import androidx.room.Room
import com.example.inspiringpersons.InspiringPersons

object InspiringPersonsDatabaseBuilder {

    private var instance: InspiringPersonDatabase? = null

    fun getInstance(): InspiringPersonDatabase {
        synchronized(InspiringPersonDatabase::class){
            if (instance == null){
                instance = buildDatabase()
            }
        }
        return instance!!
    }

    private fun buildDatabase(): InspiringPersonDatabase {
            return Room.databaseBuilder(
                InspiringPersons.application, InspiringPersonDatabase::class.java,
                InspiringPersonDatabase.NAME
            )
                .allowMainThreadQueries()
                .build()
    }
}