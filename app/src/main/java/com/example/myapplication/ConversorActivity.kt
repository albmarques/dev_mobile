package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConversorActivity : AppCompatActivity() {
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.conversor_layout)
        val btnConverter = findViewById<Button>(R.id.buttonConfirmar);

        val textMoeda = findViewById<EditText>(R.id.editTextMoeda)
        val textCotacao = findViewById<EditText>(R.id.editTexCota)
        val textResult = findViewById<TextView>(R.id.textViewResultado)

        btnConverter.setOnClickListener {
            val moeda= textMoeda.text.toString().toFloat();
            val cota = textCotacao.text.toString().toFloat();

            val resultado = moeda* cota
            textResult.text ="Resultad :{$resultado}"
        }
    }
}