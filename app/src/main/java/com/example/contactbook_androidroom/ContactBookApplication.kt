package com.example.contactbook_androidroom

import android.app.Application
import com.example.contactbook_androidroom.data.ContactRoomDatabase
import com.example.contactbook_androidroom.data.repository.ContactRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ContactBookApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy { ContactRoomDatabase.getDatabase(this) }

    val repository by lazy { ContactRepository(database.contactDao()) }

}