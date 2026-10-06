package com.example.lancheria

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var labelTitulo: TextView
    private lateinit var labelTitulo2: TextView
    private lateinit var checkHamburguer: CheckBox
    private lateinit var checkRefrigerante: CheckBox
    private lateinit var checkBatata: CheckBox
    private lateinit var checkSobremesa: CheckBox
    private lateinit var imgCombo: ImageView
    private lateinit var labelTotal: TextView

    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        checkHamburguer = findViewById(R.id.checkHamburguer)
        checkBatata = findViewById(R.id.checkBatata)
        checkRefrigerante = findViewById(R.id.checkRefrigerante)
        checkSobremesa = findViewById(R.id.checkSobremesa)
        btnCalcular = findViewById(R.id.btnCalcular)
        labelTotal = findViewById(R.id.labelTotal)

        btnCalcular.setOnClickListener {
            var total = 0.0

            if (checkHamburguer.isChecked) {
                total += 12.00
            }
            if (checkBatata.isChecked) {
                total += 8.00
            }
            if (checkRefrigerante.isChecked) {
                total += 6.00
            }
            if (checkSobremesa.isChecked) {
                total += 10.00
            }
            labelTotal.text = "Total: R$ %.2f".format(total)
        }
    }


}