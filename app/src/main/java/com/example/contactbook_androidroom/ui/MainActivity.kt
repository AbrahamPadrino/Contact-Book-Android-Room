package com.example.contactbook_androidroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactbook_androidroom.adapter.ItemAdapter
import com.example.contactbook_androidroom.data.ContactDataSourceBuilder
import com.example.contactbook_androidroom.databinding.ActivityMainBinding
import com.example.contactbook_androidroom.ui.view.models.Person

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide() //Ocultar el Action Bar de la app
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}