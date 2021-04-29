package com.example.inspiringpersons.persistence

import androidx.room.TypeConverter
import com.google.gson.Gson

class QuotesConverter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromQuotes(quotes: List<String>): String {
            return Gson().toJson(quotes)
        }

        @TypeConverter
        @JvmStatic
        fun toQuote(quotes: String): List<String> {
            return Gson().fromJson(quotes, Array<String>::class.java).toList()
        }
    }
}