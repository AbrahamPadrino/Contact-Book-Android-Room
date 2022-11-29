package com.example.contactbook_androidroom.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contactbook_androidroom.data.entities.ContactEntity

@Dao
interface ContactDAO {

        @Query("SELECT * FROM contact_table ORDER BY name ASC")
        fun getContacts(): List<ContactEntity>

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertContact(word: ContactEntity)

        //@Query("DELETE FROM word_table")
        //suspend fun deleteAll()

}