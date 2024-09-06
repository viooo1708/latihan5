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

class KonfersiSuhu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_konfersi_suhu)

        val inputSuhu =findViewById<EditText>(R.id.inputSuhu)
        val btnKonversi = findViewById<Button>(R.id.btnKonversi)
        val outfahrenheit = findViewById<TextView>(R.id.outfahrenheit)
        val outkelvin = findViewById<TextView>(R.id.outkelvin)
        val outreamur = findViewById<TextView>(R.id.outreamur)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnKonversi.setOnClickListener {
            val celciusText =inputSuhu.text.toString()

            if (celciusText.isNotEmpty()){
                val celcius = celciusText.toDouble()

                //konversi suhu
                val fahrenheit =(9.0 / 5.0) * celcius + 32
                val kelvin = celcius + 273.15
                val reamur = (4.0 / 5.0) * celcius

                //tampilkan hasil
                outfahrenheit.text = "Fahrenheit: $fahrenheit °F"
                outkelvin.text = "Kelvin: $kelvin K"
                outreamur.text = "Reamur: $reamur °Ré"
            }
            else {
                Toast.makeText(this, "Masukkan suhu dalam Celsius!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}