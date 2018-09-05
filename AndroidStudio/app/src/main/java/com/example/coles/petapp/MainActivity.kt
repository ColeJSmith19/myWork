package com.example.coles.petapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.activity_main.*
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


class CurrentAnimal(val petfinder: Animal)

class Animal(val pet: Pet)

class Pet(val name: Name, val media: Media, val description: Description)

class Media(val photos: Photos)

class Photos(@SerializedName("photo") val photo: List<Photo>)

class Description(@SerializedName("\$t") val t: String)
class Photo(@SerializedName("\$t") val t: String)
class Name(@SerializedName("\$t") val t: String)

//class Name(val `$t`: String)