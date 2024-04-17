package com.example.exoapplication1

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var spinnerGender: Spinner
    private lateinit var buttonSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextName = findViewById(R.id.editTextName)
        editTextEmail = findViewById(R.id.editTextEmail)
        spinnerGender = findViewById(R.id.spinnerGender)
        buttonSubmit = findViewById(R.id.buttonSubmit)

        val genderOptions = arrayOf("Homme", "Femme", "etc +")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter

        val watcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                validateFields()
            }
        }

        editTextName.addTextChangedListener(watcher)
        editTextEmail.addTextChangedListener(watcher)

        buttonSubmit.isEnabled = false

        buttonSubmit.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()
            val gender = spinnerGender.selectedItem.toString()

            val profile = Profile(name, email, gender)
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("profile", profile)
            startActivity(intent)
        }
    }

    private fun validateFields() {
        val name = editTextName.text.toString()
        val email = editTextEmail.text.toString()
        val gender = spinnerGender.selectedItem.toString()
        buttonSubmit.isEnabled = name.isNotBlank() && email.isNotBlank() && gender.isNotBlank()
    }
}
