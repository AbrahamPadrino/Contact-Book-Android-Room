package com.example.contactbook_androidroom.data.repository

import com.example.contactbook_androidroom.data.ContactDAO
import com.example.contactbook_androidroom.data.entities.ContactEntity
import com.example.contactbook_androidroom.data.entities.PersonEntity

class ContactRepository(
    private val contactDAO: ContactDAO
) {

    suspend fun getContacts(): List<PersonEntity> {
        val contacts = contactDAO.getContacts()
        val peopleContacts = contacts.map {
            PersonEntity(
                id = it.id,
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

    private fun mapToContactEntity(entity: PersonEntity) : ContactEntity = ContactEntity(
        id = entity.id,
        name = entity.name,
        email = entity.email,
        phone = entity.phone
    )

}