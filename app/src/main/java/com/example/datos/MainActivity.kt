package com.example.datos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.datos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var spinner = ""
        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this, R.array.DATA,
            android.R.layout.simple_spinner_item
        )
        binding.spnData.adapter = adaptador
        binding.spnData.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                spinner = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, spinner, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinner = "No ha habido selección"
                Toast.makeText(this@MainActivity, spinner, Toast.LENGTH_SHORT).show()
            }
        }
        var mapa = mutableMapOf<String, String>()
        mapa.put(spinner, binding.etInfo.text.toString())
        binding.btnSend.setOnClickListener {
            val intentResult = Intent(this, ResultActivity::class.java)
            intentResult.putExtra("NOMBRE", binding.etInfo.text.toString())
            intentResult.putExtra("AÑO", binding.etInfo.text.toString())
            intentResult.putExtra("GENERO", binding.etInfo.text.toString())
            intentResult.putExtra("EMAIL", binding.etInfo.text.toString())
            intentResult.putExtra("TELEFONO", binding.etInfo.text.toString())
            startActivity(intentResult)
        }
    }
}


