package com.example.crud_restaurante

import android.app.Activity
import android.os.Bundle
import android.util.Log


class ListaActivity() : Activity(){
    override fun onCreate(bundle: Bundle? ){
        super.onCreate(bundle)
        setContentView(R.layout.exibir_layout)
        Log.i("LOG_TESTE",intent.getStringExtra("lista").toString())
    }
}