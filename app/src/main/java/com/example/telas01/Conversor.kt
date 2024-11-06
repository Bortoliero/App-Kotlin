package com.example.telas01

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.telas01.databinding.ActivityConversorBinding

class Conversor : AppCompatActivity() {
    private lateinit var binding:ActivityConversorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConversorBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.buttonConverter.setOnClickListener{
            val euros = binding.editEuro.text.toString().toDouble()

            val dolares = String.format("%.2f", euros * 0.8).toDouble()

            binding.textDolares.text = dolares + "$"
        }
    }


}