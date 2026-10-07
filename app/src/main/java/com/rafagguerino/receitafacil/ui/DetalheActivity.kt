package com.rafagguerino.receitafacil.ui

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafagguerino.receitafacil.databinding.ActivityDetalheBinding
import com.rafagguerino.receitafacil.model.Receita

class DetalheActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_RECEITA = "extra_receita"
    }

    private lateinit var binding: ActivityDetalheBinding

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

        exibir(receita)
    }

    private fun exibir(receita: Receita) = with(binding) {
        txtTituloDetalhe.text = receita.nome
        txtIngredientes.text = receita.ingredientes.joinToString("\n") { "• $it" }
        txtModoPreparo.text = receita.modoPreparo

        receita.imagemRes?.let { imgDetalhe.setImageResource(it) }
    }
}