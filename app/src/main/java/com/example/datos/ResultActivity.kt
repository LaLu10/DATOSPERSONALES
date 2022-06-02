package com.example.datos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datos.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val datos=intent.extras
        binding.textView.text= datos?.get("NOMBRE").toString() + datos?.get("AÑO").toString()+datos?.get("GENERO").toString()+datos?.get("EMAIL").toString()+datos?.get("TELEFONO").toString()
    }
}