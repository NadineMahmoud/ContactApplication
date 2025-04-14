package com.example.contactsapp

data class Contact(
    val name : String,
    val phone : String,
    val email : String,
    val image : Int = R.drawable.baseline_account_circle_24
)
