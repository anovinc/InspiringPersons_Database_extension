package com.example.inspiringpersons.model

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "persons")
data class InspiringPerson(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="picture") val picture: String,
    @ColumnInfo(name="lifetime") val lifetime: String,
    @ColumnInfo(name="details") val details: String,
    @ColumnInfo(name="qoutes") val quotes: List<String>
):Serializable