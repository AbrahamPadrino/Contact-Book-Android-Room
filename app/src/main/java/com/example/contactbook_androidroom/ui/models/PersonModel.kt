package com.example.contactbook_androidroom.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonModel(
    val name: String,
    val email: String,
    val phone: String
) : Parcelable
