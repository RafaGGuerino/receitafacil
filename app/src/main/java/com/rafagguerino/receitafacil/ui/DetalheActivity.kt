package com.rafagguerino.receitafacil.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.rafagguerino.receitafacil.R
import com.rafagguerino.receitafacil.data.FavoritosStorage
import com.rafagguerino.receitafacil.databinding.ActivityDetalheBinding
import com.rafagguerino.receitafacil.model.Receita

class DetalheActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_RECEITA = "extra_receita"
    }

    private lateinit var binding: ActivityDetalheBinding
    private lateinit var receitaAtual: Receita
    private var isFavorito = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Seta de voltar na barra superior
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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

        isFavorito = FavoritosStorage.isFavorito(this, receitaAtual.id)

        exibir(receitaAtual)
        atualizarIconeFavorito()

        binding.fabFavorito.setOnClickListener {
            isFavorito = !isFavorito
            FavoritosStorage.setFavorito(this, receitaAtual.id, isFavorito)
            atualizarIconeFavorito()
        }
    }

    // Seta de voltar: apenas fecha a tela (a lista é atualizada no onResume da MainActivity)
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun exibir(receita: Receita) = with(binding) {
        txtTituloDetalhe.text = receita.nome
        txtCategoriaTempo.text = getString(
            R.string.detalhes_basicos,
            receita.categoria,
            receita.tempoPreparoMin
        )
        txtIngredientes.text = receita.ingredientes.joinToString("\n") { "• $it" }
        txtModoPreparo.text = receita.modoPreparo
        receita.imagemRes?.let { imgDetalhe.setImageResource(it) }

        // Observação é opcional: só exibe a seção quando existe texto
        val observacao = receita.observacao
        if (observacao.isNullOrBlank()) {
            containerObservacao.visibility = View.GONE
        } else {
            txtObservacao.text = observacao
            containerObservacao.visibility = View.VISIBLE
        }
    }

    private fun atualizarIconeFavorito() {
        val icone = if (isFavorito) {
            android.R.drawable.btn_star_big_on
        } else {
            android.R.drawable.btn_star_big_off
        }
        binding.fabFavorito.setImageResource(icone)
    }
}
