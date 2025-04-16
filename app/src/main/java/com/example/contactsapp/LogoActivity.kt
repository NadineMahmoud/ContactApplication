package com.example.contactsapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logo_activity)

        Handler(mainLooper).postDelayed({navigateToContactsActivity()},2000)


    }
    private fun navigateToContactsActivity() {
        val intent = Intent(this, ContactsActivity::class.java)
        startActivity(intent)
        finish()
    }

}