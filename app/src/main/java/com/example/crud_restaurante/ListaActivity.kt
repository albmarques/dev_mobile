package com.example.crud_restaurante

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.google.gson.Gson


class ListaActivity() : Activity(){
    val gson= Gson()
    override fun onResume(){
        super.onResume()
        setContentView(R.layout.exibir_layout)
        val listView =findViewById<ListView>(R.id.listViewRestaurante)

        val btnVoltar = findViewById<Button>(R.id.button)

        var listaRestaurante = intent.getStringExtra("LISTA")
        val lista = gson.fromJson(listaRestaurante, ArrayList<Restaurante>()::class.java)
        Log.i("LOG_RESTAURANTE","lista "+lista.toString())

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
        listView.adapter = adapter

        btnVoltar.setOnClickListener{
            var i = Intent(this, RestauranteActivity::class.java)
            startActivity(i)
        }
    }

}