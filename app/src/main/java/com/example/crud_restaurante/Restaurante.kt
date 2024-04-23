package com.example.crud_restaurante


data class Restaurante(
    var id: Long,
    var nome: String,
    var endereco: String,
    var latitude: Double,
    var longitude: Double,
    var tipoComida: String,
    var descricao: String
) {

override fun toString(): String {
    return nome+" "+endereco+" "+" "+latitude+" "+longitude+" "+tipoComida+" "+descricao
}
}