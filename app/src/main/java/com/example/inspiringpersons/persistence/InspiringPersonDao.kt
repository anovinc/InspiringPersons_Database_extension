package com.example.inspiringpersons.persistence

import androidx.room.*
import com.example.inspiringpersons.model.InspiringPerson

@Dao
interface InspiringPersonDao  {

    @Query("SELECT * FROM persons")
    fun getInspiringPersons() : List<InspiringPerson>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(inspiringPerson: InspiringPerson)

    @Delete
    fun delete(inspiringPerson: InspiringPerson)

    @Query("SELECT * FROM persons WHERE id=:id")
    fun getInspiringPerson(id: Long): InspiringPerson

}