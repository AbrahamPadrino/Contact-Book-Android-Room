package com.example.contactbook_androidroom

import android.app.Application
import com.example.contactbook_androidroom.data.db.ContactRoomDatabase
import com.example.contactbook_androidroom.data.repository.ContactRepository

class ContactBookApplication: Application() {

    private val database by lazy { ContactRoomDatabase.getDatabase(this) }

    val repository by lazy { ContactRepository(database.contactDao()) }

}