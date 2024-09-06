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

class DiskonBelanja : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diskon_belanja)

        val inputTotalBelanja = findViewById<EditText>(R.id.inputTotalBelanja)
        val btnHitungDiskon = findViewById<Button>(R.id.btnHitungDiskon)
        val outputDiskon = findViewById<TextView>(R.id.outputDiskon)
        val outputTotalBayar = findViewById<TextView>(R.id.outputTotalBayar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tombol hitung diskon di-click
        btnHitungDiskon.setOnClickListener {
            val totalBelanjaText = inputTotalBelanja.text.toString()

            if (totalBelanjaText.isNotEmpty()) {
                val totalBelanja = totalBelanjaText.toDouble()
                var diskon = 0.0

                // Menentukan besaran diskon
                when {
                    totalBelanja >= 1_000_000 -> diskon = 0.30
                    totalBelanja >= 500_000 -> diskon = 0.20
                    totalBelanja >= 100_000 -> diskon = 0.10
                }

                // Menghitung nilai diskon dan total bayar
                val nilaiDiskon = totalBelanja * diskon
                val totalBayar = totalBelanja - nilaiDiskon

                // Menampilkan hasil
                outputDiskon.text = "Diskon: Rp ${"%.2f".format(nilaiDiskon)}"
                outputTotalBayar.text = "Total Bayar: Rp ${"%.2f".format(totalBayar)}"
            } else {
                Toast.makeText(this, "Masukkan total belanja yang valid!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}