package com.example.contactbook_androidroom.data.repository

import com.example.contactbook_androidroom.data.db.ContactDAO
import com.example.contactbook_androidroom.data.entities.ContactEntity
import com.example.contactbook_androidroom.data.entities.PersonEntity

class ContactRepository(
    private val contactDAO: ContactDAO
) {

    fun getContacts(): List<PersonEntity> {
        val contacts = contactDAO.getContacts()
        val peopleContacts = contacts.map {
            PersonEntity(
                name = it.name,
                email = it.email,
                phone = it.phone
            )
        }

        return peopleContacts
    }

    suspend fun insertContact(personEntity: PersonEntity) {
        val entity = mapToContactEntity(personEntity)
        contactDAO.insertContact(entity)
    }

    suspend fun updateContact(personEntity: PersonEntity) {
        val entity = mapToContactEntity(personEntity)
        contactDAO.updateContact(entity)
    }

    private fun mapToContactEntity(entity: PersonEntity) : ContactEntity = ContactEntity(
        name = entity.name,
        email = entity.email,
        phone = entity.phone
    )

}