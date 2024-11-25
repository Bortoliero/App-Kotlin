package com.example.telas01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.telas01.databinding.ActivityCustoViagemBinding

class CustoViagem : AppCompatActivity() {
    private lateinit var binding: ActivityCustoViagemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCustoViagemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text_distance = findViewById<EditText>(R.id.distance) // binding.distance.text.toString().toDoubleOrNull()
        val text_fuel_consumption = findViewById<EditText>(R.id.fuelConsumption) // binding.fuelConsumption.text.toString().toDoubleOrNull()
        val text_number_tolls = findViewById<EditText>(R.id.numberTolls) // binding.numberTolls.text.toString().toIntOrNull()
        val text_average_speed = findViewById<EditText>(R.id.averageSpeed) // binding.averageSpeed.text.toString().toDoubleOrNull()
        val button_calculate_travel = findViewById<Button>(R.id.calculateTravel)
        val result = findViewById<TextView>(R.id.result)


        button_calculate_travel.setOnClickListener{
            val distance = text_distance.text.toString().toDoubleOrNull()
            val fuel_consumption = text_fuel_consumption.text.toString().toDoubleOrNull()
            val number_tolls = text_number_tolls.text.toString().toIntOrNull()
            val average_speed = text_average_speed.text.toString().toDoubleOrNull()

            if(distance != null && fuel_consumption != null && number_tolls != null && average_speed != null){
                // Constantes
                val fuel_price = 5.85
                val tolls_price = 10.50

                // Cálculos
                val liters_used = distance / fuel_consumption
                val total_fuel_costs = liters_used * fuel_price
                val total_tolls_costs = number_tolls * tolls_price
                val total_cost = total_fuel_costs + total_tolls_costs
                val time_spent = distance / average_speed

                // Exibir resultados
                val final_result = """
                    Distância total: %.2f km
                    Velocidade média: %.2f km/h
                    Tempo estimado de viagem: %.2f horas
                    Litros utilizados: %.2f L
                    Custo com combustível: R$ %.2f
                    Custo com pedágios: R$ %.2f
                    Custo total da viagem: R$ %.2f
                """.trimIndent().format(distance, average_speed, time_spent, liters_used, total_fuel_costs, total_tolls_costs, total_cost)

                result.text = final_result
            } else {
                result.text = "Por favor, preencha todos os campos corretamente."
            }

        }

        binding.icVoltar.setOnClickListener{
            val voltarTemperatura = Intent(this, Temperatura::class.java)
            startActivity(voltarTemperatura)
        }
        binding.icNavegar.setOnClickListener{
            val navegarTelaInicial = Intent(this, MainActivity::class.java)
            startActivity(navegarTelaInicial)
        }
    }
}