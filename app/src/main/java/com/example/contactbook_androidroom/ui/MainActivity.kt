package com.example.contactbook_androidroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactbook_androidroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide() //Ocultar el Action Bar de la app
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}