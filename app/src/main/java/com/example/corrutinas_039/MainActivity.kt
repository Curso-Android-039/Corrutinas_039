package com.example.corrutinas_039

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.corrutinas_039.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

   private lateinit var  binding: ActivityMainBinding
   val repository : PersonRepository = PersonRepositoryImpl()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val textViewPerson = binding.textViewPerson
        textViewPerson.text =""

        val buttonGetListPerson = binding.buttonGetList
        val progressBar = binding.progressBar

        buttonGetListPerson.setOnClickListener {

            textViewPerson.text =""
            progressBar.visibility = View.VISIBLE

            lifecycleScope.launch {


                val listPerson = withContext(Dispatchers.IO){

                    Thread.sleep(2000)
                    repository.getPersonas()
                }

                for(persona in listPerson){
                    textViewPerson.append("Nombre ${persona.name} ${persona.surname} |edad ${persona.edad}\n ")

                }

                 progressBar.visibility = View.INVISIBLE


            }





        }



    }
}