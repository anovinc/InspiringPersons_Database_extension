package com.example.inspiringpersons.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.inspiringpersons.persistence.InspiringPersonDao
import com.example.inspiringpersons.persistence.InspiringPersonsDatabaseBuilder
import com.example.inspiringpersons.R
import com.example.inspiringpersons.model.InspiringPerson
import com.example.inspiringpersons.databinding.ActivityNewInspiringPersonBinding
import kotlinx.android.synthetic.main.activity_new_inspiring_person.*

class NewInspiringPersonActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNewInspiringPersonBinding
    private val personRepository : InspiringPersonDao by lazy {
        InspiringPersonsDatabaseBuilder.getInstance().inspiringPersonDao()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNewInspiringPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btSaveNewInspiringPerson.setOnClickListener { saveNewInspiringPerson() }
    }


    private fun createInspiringPerson(): InspiringPerson? {
        val personName = et_new_inspiring_person_name.text.toString()
        val personLifetime = et_new_inspiring_person_lifetime.text.toString()
        val personDetails = et_new_inspiring_person_details.text.toString()
        val personPhoto = et_new_inspiring_person_picture.text.toString()
        val personQuote1 = et_new_inspiring_person_quote1.text.toString()
        val personQuote2 = et_new_inspiring_person_quote2.text.toString()
        val personQuote3 = et_new_inspiring_person_quote3.text.toString()


        var newInspiringPerson: InspiringPerson? = null
        if(personName.isEmpty() || personLifetime.isEmpty() || personDetails.isEmpty() || personPhoto.isEmpty() || personQuote1.isEmpty() ||
            personQuote2.isEmpty() || personQuote3.isEmpty()){
            return newInspiringPerson

        }
        else{

            return InspiringPerson(0,personName,personPhoto,personLifetime,personDetails, listOf(personQuote1,personQuote2,personQuote3))

            }
    }



    private fun startInspiringPersonsList(){
        val intent=Intent(this, InspiringPersonsListActivity::class.java).apply {  }
        startActivity(intent)
        finish()
    }

    private fun saveNewInspiringPerson() {
        val newInspiringPerson = createInspiringPerson()


        if (newInspiringPerson != null) {
            personRepository.insert(newInspiringPerson)
            startInspiringPersonsList()
            Toast.makeText(this, R.string.successfulSave, Toast.LENGTH_SHORT).show()
        }

        else{
            Toast.makeText(this,R.string.badEntry,Toast.LENGTH_SHORT).show()
        }



    }
}
