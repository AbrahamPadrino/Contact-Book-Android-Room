package com.example.contactbook_androidroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactbook_androidroom.adapter.ItemAdapter
import com.example.contactbook_androidroom.data.ContactDataSourceBuilder
import com.example.contactbook_androidroom.view.models.Person

class MainActivity : AppCompatActivity() {

    /**
     * @param contacts: Lista de contactos a utilizar para mostrar en la vista
     */
    private val contacts: List<Person>
        get() = ContactDataSourceBuilder(this).getContacts()

    private val contactAdapter = ItemAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactAdapter.add(contacts)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = contactAdapter
    }
}