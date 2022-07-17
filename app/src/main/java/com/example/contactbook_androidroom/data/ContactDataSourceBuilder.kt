package com.example.contactbook_androidroom.data

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.contactbook_androidroom.view.models.Person
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ContactDataSourceBuilder(private val context: Context) {

    private lateinit var jsonString: String

    private fun printLog() {
        Log.d("ContactsDataJSON => ", jsonString)
    }

    private fun readJsonFromAssets(): String {
        return context.assets
            .open("contact_data_source.json")
            .bufferedReader()
            .use { it.readText() }
    }

    private fun parseJsonToDataType(): List<Person> {
        jsonString = readJsonFromAssets()
        printLog()
        val personJSONType = object : TypeToken<List<Person>>() {}.type
        val personList: List<Person> = Gson().fromJson(jsonString, personJSONType)
        Log.d("PersonParsedList =>", personList.toString())
        return personList
    }

    fun getContacts() = parseJsonToDataType()

}