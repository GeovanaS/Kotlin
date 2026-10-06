package com.example.conversordemoedas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var reais: EditText
    private lateinit var tipomoeda: Spinner
    private lateinit var converter: Button
    private lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        reais = findViewById(R.id.reais)
        tipomoeda = findViewById(R.id.tipomoeda)
        converter = findViewById(R.id.converter)
        resultado = findViewById(R.id.resultado)

        converter.setOnClickListener {
            val valor = reais.text.toString().toDoubleOrNull()
            if(valor == null){
                resultado.text = "Digite um valor válido"
                return@setOnClickListener
            }

            val convertido = when (tipomoeda.selectedItem.toString()){
                "Dolar" -> valor/0.19
                "Euro" -> valor/292.43
                "Pesos" -> valor/0.17
                else -> 0.0
            }

            resultado.text = "Resultado: %.2f".format(convertido)

        }


    }
}