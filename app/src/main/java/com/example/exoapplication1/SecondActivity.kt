package com.example.exoapplication1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val spinnerGender = findViewById<Spinner>(R.id.spinnerGender)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)

        val genderOptions = arrayOf("Homme", "Femme")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderOptions)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter

        buttonSubmit.setOnClickListener {
            val name = editTextName.text.toString();
            val email = editTextEmail.text.toString();
            val gender = spinnerGender.selectedItem.toString();

            val intent = Intent(this, ThirdActivity::class.java);

            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("gender", gender);
            startActivity(intent);
        }
    }
}
