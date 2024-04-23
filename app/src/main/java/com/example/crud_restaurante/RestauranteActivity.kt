package com.example.crud_restaurante

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson

class RestauranteActivity():Activity() {
    val list = ArrayList <Restaurante>()
    val gson= Gson()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.cadastro_layout);
        /*
        val sp = getSharedPreferences("cadastro.restaurante", Context.MODE_PRIVATE)
        val listaString = sp.getString("LISTA", "[]")
        val arrayRestauranteType = object : TypeToken<MutableList<Restaurante>>() {}.type
        list.clear()
        list.addAll(gson.fromJson(listaString, arrayRestauranteType))
    */
        val txtNome = findViewById<TextView>(R.id.editTextNomeRestaaurante)
        val txtEndereco = findViewById<TextView>(R.id.editTextEndereco)
        val txtTipo = findViewById<TextView>(R.id.editTextTipo)
        val txtLatitude = findViewById<TextView>(R.id.editTextLatitude)
        val txtLongitude = findViewById<TextView>(R.id.editTextLongitude)
        val txtDescricao = findViewById<TextView>(R.id.editTextDescricao)


        val btnSalvar = findViewById<Button>(R.id.buttonSalvar)
        val btnVerLista = findViewById<Button>(R.id.buttonVerLista)


        btnSalvar.setOnClickListener{
            val r1 = Restaurante(
                0,
                txtNome.text.toString(),
                txtEndereco.text.toString(),
                txtLatitude.text.toString().toDouble(),
                txtLongitude.text.toString().toDouble(),
                txtTipo.text.toString(),
                txtDescricao.text.toString()
            )
            list.add(r1)
            salvarPrefs()
            Log.i("RESTAURANTE_LOG","$list")
            /*
            var listaString = gson.toJson(list)
            Log.i("AGENDA CONTATO", listaString)

            sp.edit().apply {
                putString("LISTA", listaString)
                commit()
            }
            */

        }

        btnVerLista.setOnClickListener{
            carregarPrefs()
        }
    }

    fun salvarPrefs(){
        val strRestaurantes = gson.toJson(list)
        val sp = this.getSharedPreferences("RESTAURANTES", MODE_PRIVATE)
        sp.edit().apply{
            putString("TEXTO",strRestaurantes)
            commit()
        }


    }
    fun carregarPrefs(){
        val sp = this.getSharedPreferences("RESTAURANTES", MODE_PRIVATE)
        val strRestaurantes = sp.getString("TEXTO","[]")
        val intent = Intent(this, ListaActivity::class.java)
        intent.putExtra("lista",strRestaurantes)
        startActivity(intent)
    }
}