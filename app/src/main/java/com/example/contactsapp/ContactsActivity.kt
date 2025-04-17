package com.example.contactsapp

import ValidationUtils.validateName
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.contactsapp.databinding.ActivityContactsBinding
import com.example.contactsapp.databinding.BottomSheetBinding
import com.example.contactsapp.databinding.ItemContactBinding
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
        OnAddContactClick()
    }
    private fun OnAddContactClick() {
        binding.floatingBtn.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(this)
            val bottomSheetBinding = BottomSheetBinding.inflate(layoutInflater)
            bottomSheetDialog.setContentView(bottomSheetBinding.root)
                bottomSheetDialog.show()
                bottomSheetBinding.addContactBtn.setOnClickListener {
                  if (!validateTextField(bottomSheetBinding)) {
                        return@setOnClickListener

               }
                    val contact = Contact(name = bottomSheetBinding.nameEdit.text.toString(),
                        phone = bottomSheetBinding.phoneEdit.text.toString(),
                        email = bottomSheetBinding.emailEdit.text.toString(),)


                    adapter.addContact(contact)
                    updateUI()
            }
        }
    }

    private fun validateTextField(binding: BottomSheetBinding): Boolean {

        val name = binding.nameEdit.text?.trim().toString()
        val email = binding.emailEdit.text?.trim().toString()
        val phone = binding.phoneEdit.text?.trim().toString()

       val nameError = validateName(name)
        val mailError=  ValidationUtils.validateEmail(email)
        val phoneError=  ValidationUtils.validatePhone(phone)

        binding.nameLayout.error = nameError
        binding.emaillayout.error = mailError
        binding.phoneLayout.error = phoneError
        return nameError == null && mailError == null && phoneError == null

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