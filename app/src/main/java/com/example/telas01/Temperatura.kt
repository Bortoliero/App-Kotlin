package com.example.telas01

import android.os.Bundle
import java.math.BigDecimal
import androidx.appcompat.app.AppCompatActivity
import com.example.telas01.databinding.ActivityTemperaturaBinding

class Temperatura : AppCompatActivity() {
    private lateinit var binding: ActivityTemperaturaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTemperaturaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonConverter.setOnClickListener {
            if (binding.editCelsius.text.toString().isNotEmpty()){
                val celsius = binding.editCelsius.text.toString().toDouble()
                val fahrenheit = String.format("%.2f", celsius * 1.8 + 32)

                binding.textResultado.text = "$fahrenheit ºF"

            } else {
                binding.textResultado.text = "TEMPERATURA INVÁLIDA"
            }
        }
    }
}