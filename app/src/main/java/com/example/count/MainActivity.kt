package com.example.count

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.Button
import android.widget.TextView
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var countValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val minusButton = findViewById<Button>(R.id.minusButton)
        val plusButton = findViewById<Button>(R.id.plusButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val count = findViewById<TextView>(R.id.count)

        minusButton.setOnClickListener {
            countValue--
            count.text = countValue.toString()
        }

        // Menangani tombol plus
        plusButton.setOnClickListener {
            countValue++
            count.text = countValue.toString()
        }

        // Menangani tombol reset
        resetButton.setOnClickListener {
            countValue = 0
            count.text = countValue.toString()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}