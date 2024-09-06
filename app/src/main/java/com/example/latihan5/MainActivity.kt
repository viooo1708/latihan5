package com.example.latihan5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnkonversiSuhu : Button
    private lateinit var btndiskonBelanja : Button
    private lateinit var btnHitung : Button
    private lateinit var btnGanjilAtauGenap : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnkonversiSuhu= findViewById(R.id.btnkonversiSuhu)
        btndiskonBelanja = findViewById(R.id.btndiskonBelanja)
        btnHitung = findViewById(R.id.btnHitung)
        btnGanjilAtauGenap = findViewById(R.id.btnGanjilAtauGenap)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnkonversiSuhu.setOnClickListener() {
            val intentMenu2 = Intent(this@MainActivity, KonfersiSuhu::class.java)
            startActivity(intentMenu2)
        }

        btndiskonBelanja.setOnClickListener() {
            val intentMenu2 = Intent(this@MainActivity, DiskonBelanja::class.java)
            startActivity(intentMenu2)
        }
        btnHitung.setOnClickListener() {
            val intentMenu2 = Intent(this@MainActivity, Hitung::class.java)
            startActivity(intentMenu2)
        }
        btnGanjilAtauGenap.setOnClickListener() {
            val intentMenu2 = Intent(this@MainActivity, GanjilGenap::class.java)
            startActivity(intentMenu2)
        }
    }
}