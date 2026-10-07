package com.rafagguerino.receitafacil.model

import java.io.Serializable

data class Receita(
    val id: Int,
    val nome: String,
    val categoria: String,
    val tempoPreparoMin: Int,
    val ingredientes: List<String>,
    val modoPreparo: String,
    val observacao: String? = null,
    val imagemRes: Int? = null
) : Serializable