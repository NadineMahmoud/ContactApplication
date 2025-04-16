package com.example.contactsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.databinding.ItemContactBinding

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.contactViewHolder>() {
    private var contactList = mutableListOf<Contact>()
    var onDeleteClick : OnDeleteClick ?= null
    var oDeleteClick2 : ((Int) -> Unit)?= null

    fun setContactList(list: MutableList<Contact>) {
        contactList = list
    }

    fun deleteContact(position: Int) {
        contactList.removeAt(position)
        notifyItemRemoved(position)

    }fun isEmpty() =contactList.isEmpty()

    class contactViewHolder(val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            binding.name.text = contact.name
            binding.phone.text = contact.phone
            binding.mail.text = contact.email
            binding.profile.setImageResource(contact.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactViewHolder {

        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context))
        return contactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }


    override fun onBindViewHolder(holder: contactViewHolder, position: Int) {
        val contact = contactList[position]
        holder.bind(contact)
        holder.binding.delete.setOnClickListener { View->
            oDeleteClick2?.invoke(position)


        }

    }


    fun interface OnDeleteClick{
        fun onDelete(position: Int)

    }
}