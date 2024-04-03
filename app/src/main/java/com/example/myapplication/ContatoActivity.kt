package com.example.myapplication

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.os.PersistableBundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ContatoActivity() : AppCompatActivity() {

    val lista = mutableListOf<Contato>()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_layout)

        val txtNome = findViewById<EditText>(R.id.editNome)
        val txtTelefone = findViewById<EditText>(R.id.editTelefone)
        val txtEmail= findViewById<EditText>(R.id.editEmail)

        val btnSalvar = findViewById<Button>(R.id.btnConfirmar)

        val listViewContato = findViewById<ListView>(R.id.listView)
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1)
        listViewContato.adapter=adapter;


        btnSalvar.setOnClickListener{
            val c1 = Contato(txtNome.text.toString(),txtTelefone.text.toString(),txtEmail.text.toString())
            lista.add(c1)
            adapter.clear()
            for (contato in lista){
                adapter.add(contato.nome)
            }

            Log.i("AGENDA_CONTATO","Lista${lista}")
        }



    }
}