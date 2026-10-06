package com.example.calculadora

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var numero1: EditText
    private lateinit var numero2: EditText
    private lateinit var btnSomar: Button

    private lateinit var btnSubstrair: Button

    private lateinit var btnMultiplicar: Button

    private lateinit var btnDivisao: Button
    private lateinit var labelResultado: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        numero1 = findViewById(R.id.numero1)
        numero2 = findViewById(R.id.numero2)
        btnSomar = findViewById(R.id.btnSomar)
        btnSubstrair = findViewById(R.id.btnSubstrair)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        btnDivisao = findViewById(R.id.btnDivisao)

        labelResultado = findViewById(R.id.labelResultado)

        btnSomar.setOnClickListener {
            val num1 = numero1.text.toString().toDouble()
            val num2 = numero2.text.toString().toDouble()
            val soma = num1+num2
            labelResultado.text = "Resultado: $soma"
        }

        btnSubstrair.setOnClickListener {
            val num1 = numero1.text.toString().toDouble()
            val num2 = numero2.text.toString().toDouble()
            val subs = num1 - num2
            labelResultado.text = "Resultado: $subs"
        }

        btnMultiplicar.setOnClickListener {
            val num1 = numero1.text.toString().toDouble()
            val num2 = numero2.text.toString().toDouble()
            val mul = num1*num2
            labelResultado.text= "Resultado: $mul"
        }

        btnDivisao.setOnClickListener {
            val num1 = numero1.text.toString().toDouble()
            val num2 = numero2.text.toString().toDouble()
            val div = num1/num2
            labelResultado.text= "Resultado: $div"
        }

    }
}