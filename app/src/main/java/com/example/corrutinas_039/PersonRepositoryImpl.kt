package com.example.corrutinas_039

class PersonRepositoryImpl : PersonRepository {


    // referencia a la clase persona

    private val listPerson = ArrayList<Person>()

   init{
       listPerson.add(Person("Roberto","Garcia", 48))
       listPerson.add(Person("Pedro","Lopez", 25))
       listPerson.add(Person("Jose","Marin", 27))
       listPerson.add(Person("Maria","Venitez", 44))
       listPerson.add(Person("Lola","Román", 52))
   }




    override fun getPersonas(): ArrayList<Person> {
        return  listPerson
    }


}