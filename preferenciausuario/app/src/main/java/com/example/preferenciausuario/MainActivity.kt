package com.example.preferenciausuario

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var rgSexo: RadioGroup
    private lateinit var rgEstadoCivil: RadioGroup

    private lateinit var cbCaminhada: CheckBox
    private lateinit var cbNatacao: CheckBox
    private lateinit var cbEsporteIndvidual: CheckBox
    private lateinit var cbEsporteColetivo: CheckBox

    private lateinit var btnResumo: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etNome = findViewById(R.id.etNome)
        rgSexo = findViewById(R.id.rgSexo)
        rgEstadoCivil = findViewById(R.id.rgEstadoCivil)

        cbCaminhada = findViewById(R.id.cbCaminhada)
        cbNatacao = findViewById(R.id.cbNatacao)
        cbEsporteIndvidual = findViewById(R.id.cbEsporteIndividual)
        cbEsporteColetivo = findViewById(R.id.cbEsporteColetivo)

        btnResumo = findViewById(R.id.btnResumo)
        tvResultado = findViewById(R.id.tvResultado)

        btnResumo.setOnClickListener {
            val nome = etNome.text.toString().ifBlank { "Sem nome" }

            var sexo = when (rgSexo.checkedRadioButtonId){
                R.id.rbMasc -> "Masculino"
                R.id.rbFem -> "Feminino"
                else -> "Indefinido"
            }

            val estadoCivil = when (rgEstadoCivil.checkedRadioButtonId){
                R.id.rbSolteiro -> "Solteiro"
                R.id.rbCasado -> "Casado"
                R.id.rbDivorciado -> "Divorciado"
                else -> "Indefinido"
            }

            val atividades = mutableListOf<String>()
            if (cbCaminhada.isChecked) atividades.add("Caminhada")
            if (cbNatacao.isChecked) atividades.add("Natação")
            if (cbEsporteIndvidual.isChecked) atividades.add("Esporte Individual")
            if (cbEsporteColetivo.isChecked) atividades.add("Esporte Coletivo")

            val resultado = "$nome, $sexo. \n$estadoCivil \nAtividades: $atividades."
            tvResultado.text = resultado
        }
    }
}