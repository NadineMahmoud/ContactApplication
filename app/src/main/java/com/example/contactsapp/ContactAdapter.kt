package com.example.contactsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.databinding.ItemContactBinding

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.contactViewHolder>(){
    class contactViewHolder(val binding : ItemContactBinding)
        : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactViewHolder {

        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context))
        return contactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: contactViewHolder, position: Int) {
        holder.binding.
    }
}