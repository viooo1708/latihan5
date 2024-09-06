package com.example.latihan5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GanjilGenap : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ganjil_genap)

        val inputBilangan = findViewById<EditText>(R.id.inputBilangan)
        val btnCek = findViewById<Button>(R.id.btnCek)
        val outputHasil = findViewById<TextView>(R.id.outputHasil)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnCek.setOnClickListener {
            val bilanganText = inputBilangan.text.toString()

            if (bilanganText.isNotEmpty()) {
                val bilangan = bilanganText.toInt()

                // Cek apakah bilangan ganjil atau genap
                val hasil = if (bilangan % 2 == 0) {
                    "$bilangan adalah bilangan genap"
                } else {
                    "$bilangan adalah bilangan ganjil"
                }

                // Tampilkan hasil
                outputHasil.text = "Hasil: $hasil"
            } else {
                Toast.makeText(this, "Masukkan bilangan bulat!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}