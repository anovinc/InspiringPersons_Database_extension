package com.example.inspiringpersons.listeners

import com.example.inspiringpersons.model.InspiringPerson

interface OnInspiringPersonSelected {
    fun OnInspiringPersonClicked(inspiringPerson:InspiringPerson)
    fun deletePerson(inspiringPerson: InspiringPerson, position : Int)
}