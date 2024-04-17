package com.example.exoapplication1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FourthActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fourth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val profile = intent.getParcelableExtra<Profile>("profile")

        val textViewName = findViewById<TextView>(R.id.textViewName)
        val textViewEmail = findViewById<TextView>(R.id.textViewEmail)
        val textViewGender = findViewById<TextView>(R.id.textViewGender)

        textViewName.text = "Nom: ${profile?.name}"
        textViewEmail.text = "Email: ${profile?.email}"
        textViewGender.text = "Genre: ${profile?.gender}"

        val backBtn = findViewById<Button>(R.id.buttonBackToMain)
        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
