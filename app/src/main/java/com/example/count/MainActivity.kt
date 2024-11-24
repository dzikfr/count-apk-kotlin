package com.example.count

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var countValue = 0
    private var cartValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val minusButton = findViewById<Button>(R.id.minusButton)
        val plusButton = findViewById<Button>(R.id.plusButton)
        val addToCartButton = findViewById<Button>(R.id.resetButton)
        val clearCartButton = findViewById<Button>(R.id.clearButton)
        val count = findViewById<TextView>(R.id.count)
        val cart = findViewById<TextView>(R.id.cartText)

        minusButton.setOnClickListener {
            if (countValue > 0) {
                countValue--
                count.text = countValue.toString()
            }
        }

        plusButton.setOnClickListener {
            countValue++
            count.text = countValue.toString()
        }

        addToCartButton.setOnClickListener {

            cartValue += countValue
            countValue = 0
            count.text = countValue.toString()
            cart.text = cartValue.toString()

            Toast.makeText(this, "Bergasil menambahkan", Toast.LENGTH_SHORT).show()
        }

        clearCartButton.setOnClickListener {
            cartValue = 0
            cart.text = cartValue.toString()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
