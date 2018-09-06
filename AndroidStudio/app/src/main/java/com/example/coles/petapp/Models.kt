package com.example.coles.petapp

import com.google.gson.annotations.SerializedName

class CurrentAnimal(val petfinder: Animal)
class Animal(val pet: Pet)
class Pet(val name: Name, val media: Media, val description: Description)
class Media(val photos: Photos)
class Photos(@SerializedName("photo") val photo: List<Photo>)
class Description(@SerializedName("\$t") val t: String)
class Photo(@SerializedName("\$t") val t: String)
class Name(@SerializedName("\$t") val t: String)

