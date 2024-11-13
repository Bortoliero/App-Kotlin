package com.example.telas01

import android.os.Bundle
import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.telas01.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icNavegar.setOnClickListener{
            val navegarSegundaTela = Intent(this, Conversor::class.java)
            startActivity(navegarSegundaTela)
        }
    }
}