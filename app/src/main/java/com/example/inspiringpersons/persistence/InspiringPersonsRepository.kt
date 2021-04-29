package com.example.inspiringpersons.persistence

import com.example.inspiringpersons.model.InspiringPerson

object InspiringPersonsRepository {

     private val inspiringPersons= mutableListOf(
         InspiringPerson(0,
             "Ada Lovelace",
             "https://voxfeminae.net/wp-content/uploads/2018/09/732c98979242d49d895e1ee7354d488d.jpg",
             "1815. - 1852.",
                     " Published notes about engine which today we consider as first ever algorithm."
             ,
             listOf( "That brain of mine is something more than merely mortal; as time will show.",
                 "The more I study, the more insatiable do I feel my genius for it to be.”",
                 "Religion to me is science, and science to me is religion.")
         ),
         InspiringPerson(0,
             "Larry Page",
             "https://specials-images.forbesimg.com/imageserve/5de7d8c0b269e900075d5ecb/960x0.jpg?fit=scale",
             "1973. -",
             "While studying in California, Larry Page co-founded Google as a research project with the help of Sergey Brin",
             listOf( "Always deliver more than expected.",
                 "If you’re not some things that are crazy, then you’re doing the wrong things.",
                 "It’s very hard to fail completely if you aim high enough.")
         ),
         InspiringPerson(0,
             "Steve Jobs",
             "https://poslovnipuls.com/wp-content/uploads/2018/09/steve-jobs.jpg",
             "1955. - 2011.",
             "Founder of Apple, famous company that is responisble for IPhone, Mac, IPad, IPod.",
             listOf(
                 "Don’t let the noise of others’ opinions drown out your own inner voice.",
                 "I think the things you regret most in life are the things you didn’t do.",
                 "Your time is limited, so don’t waste it living someone else’s life."
             )
         )
     )
     fun getInspiringPersons():List<InspiringPerson> = inspiringPersons
     fun insert(person: InspiringPerson) = inspiringPersons.add(person)
     fun getInspiringPerson(name : String) : InspiringPerson = inspiringPersons.first{ it -> it.name == name }
     fun delete(position: Int) = inspiringPersons.removeAt(position)



}