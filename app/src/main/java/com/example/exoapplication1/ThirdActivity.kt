package com.example.exoapplication1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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

        val name = intent.getStringExtra("name");
        val email = intent .getStringExtra("email");
        val gender = intent.getStringExtra("gender");

        val textViewName = findViewById<TextView>(R.id.textViewName)
        val textViewEmail = findViewById<TextView>(R.id.textViewEmail)
        val textViewGender = findViewById<TextView>(R.id.textViewGender)

        textViewName.text = "Nom: $name"
        textViewEmail.text = "Email: $email"
        textViewGender.text = "Genre: $gender"

        val buttonValidate = findViewById<Button>(R.id.buttonValidate)
        buttonValidate.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("gender", gender)

            startActivity(intent)
        }

        val isValid = validateData(name, email, gender);
        if (isValid) {
            val intent = Intent(this, FourthActivity::class.java);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Données invalides. Veuillez corriger les champs.", Toast.LENGTH_SHORT).show();
        }
    }
}
private fun validateData(name: String?, email: String?, gender: String?): Boolean {
    return !(name.isNullOrEmpty() || email.isNullOrEmpty() || gender.isNullOrEmpty());
}