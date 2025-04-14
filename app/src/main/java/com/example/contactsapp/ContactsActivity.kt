package com.example.contactsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactsapp.databinding.ActivityContactsBinding

class ContactsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityContactsBinding
    val text : String? = null
    val contactList = mutableListOf<Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUI()
    }

    private fun setUI() {
        TODO("Not yet implemented")
    }

}