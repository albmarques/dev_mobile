package com.example.crud_restaurante

import java.io.Serializable


data class Restaurante(
    var id: Long,
    var nome: String,
    var endereco: String,
    var latitude: Double,
    var longitude: Double,
    var tipoComida: String,
    var descricao: String
) : Serializable