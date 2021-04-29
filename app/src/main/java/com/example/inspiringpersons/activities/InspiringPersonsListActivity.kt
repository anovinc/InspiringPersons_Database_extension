package com.example.inspiringpersons.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inspiringpersons.persistence.InspiringPersonDao
import com.example.inspiringpersons.persistence.InspiringPersonsDatabaseBuilder
import com.example.inspiringpersons.persistence.InspiringPersonsRepository
import com.example.inspiringpersons.adapters.InspiringPersonsAdapter
import com.example.inspiringpersons.databinding.ActivityInspiringPersonsListBinding
import com.example.inspiringpersons.listeners.OnInspiringPersonSelected
import com.example.inspiringpersons.model.InspiringPerson

class InspiringPersonsListActivity : AppCompatActivity() , OnInspiringPersonSelected{

    private lateinit var inspiringPersonsBinding : ActivityInspiringPersonsListBinding
    private lateinit var listener:OnInspiringPersonSelected
    private var adapter = InspiringPersonsAdapter(this)
    private val personRepository : InspiringPersonDao by lazy {
        InspiringPersonsDatabaseBuilder.getInstance().inspiringPersonDao()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inspiringPersonsBinding = ActivityInspiringPersonsListBinding.inflate(layoutInflater)
        setContentView(inspiringPersonsBinding.root)
        setupRecycler()
        //initalPersons()
    }

    private fun initalPersons(){
        val person1 = InspiringPersonsRepository.getInspiringPerson("Ada Lovelace")
        val person2 = InspiringPersonsRepository.getInspiringPerson("Larry Page")
        val person3 = InspiringPersonsRepository.getInspiringPerson("Steve Jobs")
        personRepository.insert(person1)
        personRepository.insert(person2)
        personRepository.insert(person3)
    }

    override fun onResume() {
        super.onResume()
        (inspiringPersonsBinding.rvInspiringPersons.adapter as InspiringPersonsAdapter).update(personRepository.getInspiringPersons())
    }

    private fun setupRecycler() {
        inspiringPersonsBinding.rvInspiringPersons.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        inspiringPersonsBinding.rvInspiringPersons.adapter=adapter
        adapter.update(personRepository.getInspiringPersons())
        addNewPerson()

    }

    private fun addNewPerson(){
        inspiringPersonsBinding.btnNewInspiringPerson.setOnClickListener{
            val intent=Intent(this, NewInspiringPersonActivity::class.java).apply {  }
            startActivity(intent)
        }
    }

    override fun OnInspiringPersonClicked(inspiringPerson: InspiringPerson) {
        var random="\""+inspiringPerson.quotes.random().toString()+"\" - "+ inspiringPerson.name
        Toast.makeText(this,random,Toast.LENGTH_LONG).show()

    }

    override fun deletePerson(inspiringPerson: InspiringPerson, position : Int) {
        personRepository.delete(inspiringPerson)
        adapter.notifyItemRemoved(position)
        adapter.notifyDataSetChanged()
        adapter.update(personRepository.getInspiringPersons())
        Toast.makeText(this,"Deleted "+ inspiringPerson.name+"!",Toast.LENGTH_SHORT).show()
    }


}
