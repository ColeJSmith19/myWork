package com.example.coles.petapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.petcard.*
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Array

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // recyclerView_main.setBackgroundColor(Color.CYAN)
        recyclerView_main.layoutManager = LinearLayoutManager(this)
        //recyclerView_main.adapter = MainAdapter()

        fetchJSON()

//        nextButton.setOnClickListener {
//           // fetchJSON()
//            Toast.makeText(this@MainActivity, "Maybe you'll love this one!", Toast.LENGTH_SHORT).show()
//        }
    }

    fun nextButton(v: View){
        fetchJSON()
    }

    fun fetchJSON(){
        println("Attempting to fetch")
        val tempUrl = "http://api.petfinder.com/pet.getRandom?key=8c471c274a06a2a995c86e269b15f016&output=basic&format=json"
        val request = Request.Builder().url(tempUrl).build()
        //val belmont = "${'$'}t"
        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback{
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

                val currentAnimal = gson.fromJson(body, CurrentAnimal::class.java)


                runOnUiThread {
                    recyclerView_main.adapter = MainAdapter(currentAnimal)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute")
                println(e?.message)
            }
        })
    }
}




//class Name(val `$t`: String)