package com.example.contactbook_androidroom.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
data class ContactEntity(
    @ColumnInfo(name = "id")
    val id: Int,
    val name: String,
    val email: String,
    @PrimaryKey
    val phone: String
) {
    constructor(name: String, email: String, phone: String) : this(0, name, email, phone)
}

