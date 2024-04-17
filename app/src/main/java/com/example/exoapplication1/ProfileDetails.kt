package com.example.exoapplication1

import android.annotation.SuppressLint
import android.os.Build

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileDetails : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val profile: Profile? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            intent.getParcelableExtra("profile") as? Profile
        } else {
            intent.getParcelableExtra("profile")
        }

        val nameTextView = findViewById<TextView>(R.id.textViewName)
        val emailTextView = findViewById<TextView>(R.id.textViewEmail)
        val genderTextView = findViewById<TextView>(R.id.textViewGender)

        nameTextView.text = "Nom : ${profile?.name}"
        emailTextView.text = "Âge : ${profile?.email}"
        genderTextView.text = "Genre : ${profile?.gender}"

    }
}