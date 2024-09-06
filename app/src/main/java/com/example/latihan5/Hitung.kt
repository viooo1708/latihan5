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

class Hitung : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hitung)

        val inputPanjang = findViewById<EditText>(R.id.inputPanjang)
        val inputLebar = findViewById<EditText>(R.id.inputLebar)
        val inputTinggi = findViewById<EditText>(R.id.inputTinggi)
        val btnHitung = findViewById<Button>(R.id.btnHitung)
        val outputLuasPermukaan = findViewById<TextView>(R.id.outputLuasPermukaan)
        val outputVolume = findViewById<TextView>(R.id.outputVolume)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Tombol hitung di-click
        btnHitung.setOnClickListener {
            val panjangText = inputPanjang.text.toString()
            val lebarText = inputLebar.text.toString()
            val tinggiText = inputTinggi.text.toString()

            // Validasi input tidak kosong
            if (panjangText.isNotEmpty() && lebarText.isNotEmpty() && tinggiText.isNotEmpty()) {
                val panjang = panjangText.toDouble()
                val lebar = lebarText.toDouble()
                val tinggi = tinggiText.toDouble()

                // Menghitung luas permukaan dan volume
                val luasPermukaan = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi)
                val volume = panjang * lebar * tinggi

                // Menampilkan hasil
                outputLuasPermukaan.text = "Luas Permukaan: $luasPermukaan"
                outputVolume.text = "Volume: $volume"
            } else {
                Toast.makeText(this, "Masukkan semua nilai panjang, lebar, dan tinggi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}