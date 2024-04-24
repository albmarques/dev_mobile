package com.example.crud_agenda

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ContatoActivity():Activity() {
    val contatosArray = ArrayList<Contato>()
    val Gson = Gson()

    override fun onCreate(bundle: Bundle?) {

        super.onCreate(bundle)
        setContentView(R.layout.agenda_layout)

        val editNome = findViewById<TextView>(R.id.editTextNome)
        val editTelefone = findViewById<TextView>(R.id.editTextTelefone)
        val editEmail = findViewById<TextView>(R.id.editTextEmail)

        val btnSalvar = findViewById<Button>(R.id.buttonGravar)
        val btnPesquisar = findViewById<Button>(R.id.buttonPesquisar)

        btnSalvar.setOnClickListener(){
            val c1 = Contato(0,
                editNome.text.toString(),
                editEmail.text.toString(),
                editTelefone.text.toString()
            )
            contatosArray.add(c1)
            Log.i("LOG_AGENDA",contatosArray.toString())
            salvarPref()
        }

        btnPesquisar.setOnClickListener{
            carregarPref()
            Log.i("LOG_AGENDA",contatosArray.toString())
            for(contato in contatosArray){
                Log.i("LOG_AGENDA",contato.toString())
                if (editNome.text.toString()==contato.Nome){
                    editNome.text=contato.Nome
                    editEmail.text=contato.Email
                    editTelefone.text=contato.Telefone
                }
            }
        }

    }
    fun salvarPref(){
        val strContatos = Gson.toJson(contatosArray)
        val sp = getSharedPreferences("Contatos", MODE_PRIVATE)
        sp.edit().apply(){
            putString("TEXTO",strContatos)
            commit()
        }
    }
    fun carregarPref(){
        val sp = getSharedPreferences("Contatos", MODE_PRIVATE)
        val strContatos = sp.getString("TEXTO","[]")
        //Log.i("LOG_AGENDA",Gson.fromJson(strContatos,ArrayList<Contato>()::class.java).toString())
        val tipoLista = object : TypeToken<ArrayList<Contato>>() {}.type
        val lista = Gson.fromJson<ArrayList<Contato>>(strContatos, tipoLista)
        //val lista = Gson.fromJson(strContatos,ArrayList<Contato>()::class.java)
        contatosArray.clear()
        contatosArray.addAll(lista)
    }

}