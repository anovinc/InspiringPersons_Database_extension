package com.example.inspiringpersons.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.inspiringpersons.model.InspiringPerson

@Database(entities = [InspiringPerson::class],version = 1)
@TypeConverters( QuotesConverter::class )
abstract class InspiringPersonDatabase : RoomDatabase() {
    abstract fun inspiringPersonDao() : InspiringPersonDao

    companion object {
        const val NAME = "personsDb"
    }
}