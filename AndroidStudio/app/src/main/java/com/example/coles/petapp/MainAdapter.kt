package com.example.coles.petapp

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.petcard.view.*

class MainAdapter(val currentAnimal: CurrentAnimal): RecyclerView.Adapter<CustomViewHolder>(){

    //val petName = "Belmont"//GET request.petName

    override fun getItemCount(): Int {
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.petcard, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val petsName = currentAnimal.petfinder.pet.name
        holder.view.petName.text = petsName.t
        val petsDescription = currentAnimal.petfinder.pet.description
        holder.view.petDescription.text = petsDescription.t
        val petsPicture = holder.view.petPicture
        Picasso.get().load(currentAnimal.petfinder.pet.media.photos.photo[2].t).into(petsPicture)




    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){
    init {
        view.setOnClickListener {
            val intent = Intent(view.context, PetDetailActivity::class.java)

            intent.putExtra("adoptionInfo", "Adoption Info")


            view.context.startActivity(intent)
        }
    }
}