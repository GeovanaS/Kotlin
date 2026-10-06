package com.example.filmes

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var filmes: TextView
    private lateinit var categorias: Spinner
    private lateinit var indicar: Button
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        filmes = findViewById(R.id.top_filmes)
        categorias = findViewById(R.id.categorias)
        indicar = findViewById(R.id.indicar)
        result = findViewById(R.id.result)

        indicar.setOnClickListener{
            val indicacao = when (categorias.selectedItem.toString()){
                "Comedia" -> "\n1.As Branquelas \n2.Se Beber, Não Case!\n3. Todo Mundo em Pânico\n4. Borat\n5. SuperBad "
                "Terror" -> "\n1.O Exorcista\n2.Bruxa de Blair\n3.Invocação do Mal\n4. A Hora do Mal\n5.Panico"
                "Suspense" -> "\n1.A Origem\n2.Um Contratempo\n3.Seven\n4.Garota Exemplar\n5.Os Suspeitos"
                "Ação" -> "\n1.Mad Max\n2.Batman:O Cavaleiro das Trevas\n3.Matrix\n4.O Ultimato Bourne\n5.Bastardos Inglórios\n"
                else -> "Categoria Invalida"
            }
            result.text = "Indicação: $indicacao"
        }




    }
}