package com.rafagguerino.receitafacil.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.rafagguerino.receitafacil.databinding.ActivityDetalheBinding
import com.rafagguerino.receitafacil.model.Receita

class DetalheActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_RECEITA = "extra_receita"
    }

    private lateinit var binding: ActivityDetalheBinding
    private var favorito = false

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

        favorito = savedInstanceState?.getBoolean("favorito") ?: false
        exibir(receita)
        atualizarFavorito()

        binding.btnFavoritar.setOnClickListener {
            favorito = !favorito
            atualizarFavorito()
        }
    }

    private fun exibir(receita: Receita) = with(binding) {
        tvNomeDetalhe.text = receita.nome
        tvMeta.text = "${receita.categoria} • ${receita.tempoPreparoMin} min"
        tvIngredientes.text = receita.ingredientes.joinToString("\n") { "• $it" }
        tvPreparo.text = receita.modoPreparo
        receita.imagemRes?.let { ivDetalhe.setImageResource(it) }

        if (receita.observacao != null) {
            tvObservacao.text = "Obs.: ${receita.observacao}"
            tvObservacao.visibility = View.VISIBLE
        } else {
            tvObservacao.visibility = View.GONE
        }
    }

    private fun atualizarFavorito() = with(binding) {
        tvFavorito.text = if (favorito) "★" else "☆"
        btnFavoritar.text = if (favorito) "Remover dos favoritos" else "Favoritar"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("favorito", favorito)
    }
}