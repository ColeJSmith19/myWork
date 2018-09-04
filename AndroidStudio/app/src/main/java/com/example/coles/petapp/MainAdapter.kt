package com.example.coles.petapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.petcard.view.*

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>(){

    val petName = "Belmont"//GET request.petName

    override fun getItemCount(): Int {
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.petcard, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.petName.text = petName
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}