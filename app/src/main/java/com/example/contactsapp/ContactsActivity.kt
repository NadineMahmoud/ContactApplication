package com.example.contactsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.contactsapp.databinding.ActivityContactsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class ContactsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityContactsBinding
    private val adapter = ContactAdapter()
    val text : String? = null
    val contactList = mutableListOf<Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateUI()
        intitContactRV()
    }
    private fun OnAddContactClick(){
        binding.floatingBtn.setOnClickListener{
            val bottomSheetDialog = BottomSheetDialog(this)


        }
    }

    private fun intitContactRV() {
        binding.recyclerview.adapter = adapter
        adapter.setContactList(contactList)
        adapter.oDeleteClick2 = {position ->
            adapter.deleteContact(position)
            updateUI()
        }
    }

    private fun updateUI() {
        if(adapter.isEmpty()){
            updateUIEmptyState()

        }else{
            updateUIsuccessState()
        }
    }

    private fun updateUIsuccessState() {
        binding.recyclerview.isVisible = true
        binding.emptyView.isVisible = false
    }

    private fun updateUIEmptyState() {
        binding.recyclerview.isVisible =false
        binding.emptyView.isVisible = true
    }

}