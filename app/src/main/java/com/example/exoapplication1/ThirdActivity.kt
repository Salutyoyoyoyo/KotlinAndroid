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

class ThirdActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val profile = intent.getParcelableExtra("profile") as? Profile
        findViewById<TextView>(R.id.textViewName).text = "Nom: ${profile?.name}"
        findViewById<TextView>(R.id.textViewEmail).text = "Email: ${profile?.email}"
        findViewById<TextView>(R.id.textViewGender).text = "Genre: ${profile?.gender}"

        findViewById<Button>(R.id.buttonValidate).setOnClickListener {
            startActivity(Intent(this, FourthActivity::class.java).apply {
                putExtra("profile", profile)
            })
        }
    }
}
