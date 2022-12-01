package com.example.contactbook_androidroom.ui.viewmodels

import androidx.lifecycle.*
import com.example.contactbook_androidroom.data.entities.PersonEntity
import com.example.contactbook_androidroom.data.repository.ContactRepository
import com.example.contactbook_androidroom.ui.models.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(
    private val contactRepository: ContactRepository
): ViewModel() {

    val liveData : LiveData<List<Person>> get() = _liveData

    private val _liveData = MutableLiveData<List<Person>>()


    fun getContacts() {
        viewModelScope.launch(Dispatchers.IO) {
            val contacts : List<Person> = contactRepository.getContacts().map {
                mapToModel(it)
            }

            _liveData.postValue(contacts)
        }
    }

    fun createContact(model: Person) {
        viewModelScope.launch(Dispatchers.IO) {
            val entity = mapToEntity(model)
            contactRepository.insertContact(entity)
        }
    }

    private fun mapToModel(entity: PersonEntity) = Person(
        name = entity.name,
        id = entity.id,
        phone = entity.phone,
        email = entity.email
    )

    private fun mapToEntity(model: Person)= PersonEntity(
        id = model.id,
        name = model.name,
        email = model.email,
        phone = model.phone
    )
}

class ContactViewModelFactory(
    private val repository: ContactRepository
) :  ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ContactViewModel(repository) as T
        }
        throw java.lang.IllegalArgumentException("No se que vergas...")
    }
}