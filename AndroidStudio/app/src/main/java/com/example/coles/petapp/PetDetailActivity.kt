package com.example.coles.petapp

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coles.petapp.R.id.parent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.petcard.view.*
import java.text.FieldPosition

class PetDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = PetDetailAdapter()

        val navBarTitle = intent.getStringExtra("adoptionInfo")
        supportActionBar?.title = navBarTitle
    }

    private class PetDetailAdapter: RecyclerView.Adapter<PetDetailViewHolder>(){

        override fun getItemCount(): Int {
            return 1
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetDetailViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val customView = layoutInflater.inflate(R.layout.pet_detail, parent, false)
            return PetDetailViewHolder(customView)
        }

        override fun onBindViewHolder(holder: PetDetailViewHolder, position: Int) {

        }
    }

    private class PetDetailViewHolder(val customView: View): RecyclerView.ViewHolder(customView) {

    }
}