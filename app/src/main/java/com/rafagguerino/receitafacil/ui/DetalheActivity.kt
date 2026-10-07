package com.rafagguerino.receitafacil.ui

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafagguerino.receitafacil.databinding.ActivityDetalheBinding
import com.rafagguerino.receitafacil.model.Receita

class DetalheActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_RECEITA = "extra_receita"
        const val PREFS_FAVORITOS = "FavoritosPrefs"
    }

    private lateinit var binding: ActivityDetalheBinding
    private var isFavorito = false
    private lateinit var receitaAtual: Receita

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receita = if (Build.VERSION.SDK_INT >= 33) {
            intent.getSerializableExtra(EXTRA_RECEITA, Receita::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra(EXTRA_RECEITA) as? Receita
        }

        if (receita == null) {
            finish()
            return
        }
        receitaAtual = receita

        val prefs = getSharedPreferences(PREFS_FAVORITOS, Context.MODE_PRIVATE)
        isFavorito = prefs.getBoolean(receitaAtual.nome, false)

        exibir(receitaAtual)
        atualizarIconeFavorito()

        binding.fabFavorito.setOnClickListener {
            isFavorito = !isFavorito
            prefs.edit().putBoolean(receitaAtual.nome, isFavorito).apply()
            atualizarIconeFavorito()
        }
    }

    private fun exibir(receita: Receita) = with(binding) {
        txtTituloDetalhe.text = receita.nome
        txtIngredientes.text = receita.ingredientes.joinToString("\n") { "• $it" }
        txtModoPreparo.text = receita.modoPreparo
        receita.imagemRes?.let { imgDetalhe.setImageResource(it) }
    }

    private fun atualizarIconeFavorito() {
        if (isFavorito) {
            binding.fabFavorito.setImageResource(android.R.drawable.btn_star_big_on)
        } else {
            binding.fabFavorito.setImageResource(android.R.drawable.btn_star_big_off)
        }
    }
}