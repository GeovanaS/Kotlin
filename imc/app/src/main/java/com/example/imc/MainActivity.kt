package com.example.imc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var txtPeso: EditText
    private lateinit var txtAltura: EditText
    private lateinit var btnCalcular: Button
    private lateinit var  btnLimpar: Button
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtPeso = findViewById(R.id.txtPeso)
        txtAltura = findViewById(R.id.txtAltura)
        btnCalcular = findViewById(R.id.btnCalcular)
        txtResultado = findViewById(R.id.txtResultado)
        btnLimpar = findViewById(R.id.btnLimpar)


        btnCalcular.setOnClickListener {
            val peso = txtPeso.text.toString().toFloat();
            val altura = txtAltura.text.toString().toFloat();

            val imc = peso/(altura*altura);

            txtResultado.text = "Resultado: %.2f". format(imc)
        }

        btnLimpar.setOnClickListener{
            txtPeso.text.clear()
            txtAltura.text.clear()
            txtResultado.text = ""
            txtPeso.requestFocus()
        }
    }
}
