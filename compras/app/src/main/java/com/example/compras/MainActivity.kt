package com.example.compras

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var checkMouse: CheckBox
    private lateinit var checkMonitor: CheckBox
    private lateinit var checkApresentador: CheckBox
    private lateinit var btnCalcular: Button
    private lateinit var checkTeclado: CheckBox
    private lateinit var checkCaixa: CheckBox
    private lateinit var checkProjetor: CheckBox
    private lateinit var labelTotal: TextView
    private lateinit var qtdMouse: EditText
    private lateinit var qtdTeclado: EditText
    private lateinit var qtdMonitor: EditText
    private lateinit var  qtdCaixa: EditText
    private lateinit var  qtdApresentador: EditText
    private lateinit var qtdProjetor: EditText

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        checkMouse = findViewById(R.id.checkMouse)
        checkTeclado = findViewById(R.id.checkTeclado)
        checkMonitor = findViewById(R.id.checkMonitor)
        checkCaixa = findViewById(R.id.checkCaixa)
        checkApresentador = findViewById(R.id.checkApresentador)
        checkProjetor = findViewById(R.id.checkProjetor)
        btnCalcular = findViewById(R.id.btnCalcular)
        labelTotal = findViewById(R.id.labelTotal)
        qtdMouse = findViewById(R.id.qtdMouse)
        qtdTeclado = findViewById(R.id.qtdTeclado)
        qtdMonitor = findViewById(R.id.qtdMonitor)
        qtdCaixa = findViewById(R.id.qtdCaixa)
        qtdApresentador = findViewById(R.id.qtdApresentador)
        qtdProjetor = findViewById(R.id.qtdProjetor)

        btnCalcular.setOnClickListener {
            var soma = 0.0

            if (checkMouse.isChecked) {
                val qtMouse2 = qtdMouse.text.toString().toIntOrNull() ?: 0
                soma += 31.98 * qtMouse2
            }
            if (checkTeclado.isChecked) {
                val qtTeclado2 = qtdTeclado.text.toString().toIntOrNull() ?: 0
                soma += 29.90 * qtTeclado2
            }
            if (checkMonitor.isChecked) {
                val qtMonitor2 = qtdMonitor.text.toString().toIntOrNull() ?: 0
                soma += 560.90 * qtMonitor2
            }
            if (checkCaixa.isChecked) {
                val qtCaixa2 = qtdCaixa.text.toString().toIntOrNull() ?: 0
                soma += 139.99 * qtCaixa2
            }
            if (checkApresentador.isChecked) {
                val qtApresentador2 = qtdApresentador.text.toString().toIntOrNull() ?: 0
                soma += 50.86 * qtApresentador2
            }
            if (checkProjetor.isChecked) {
                val qtdProjetor2 = qtdProjetor.text.toString().toIntOrNull() ?: 0
                soma += 3400.00 * qtdProjetor2
            }

            labelTotal.text = "Total: R$ %.2f".format(soma)
        }
    }
}