package com.rafagguerino.receitafacil.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafagguerino.receitafacil.databinding.ActivityMainBinding
import com.rafagguerino.receitafacil.data.ReceitasMock

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mostrarApenasFavoritos = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvReceitas.layoutManager = LinearLayoutManager(this)

        // Botão "Todas"
        binding.btnTodas.setOnClickListener {
            mostrarApenasFavoritos = false
            atualizarLista()
        }

        // Botão "Favoritas"
        binding.btnFavoritas.setOnClickListener {
            mostrarApenasFavoritos = true
            atualizarLista()
        }
    }

    override fun onResume() {
        super.onResume()
        // Garante que a lista se atualize automaticamente ao voltar de uma receita
        atualizarLista()
    }

    private fun atualizarLista() {
        val prefs = getSharedPreferences(DetalheActivity.PREFS_FAVORITOS, Context.MODE_PRIVATE)
        val listaBase = ReceitasMock.receitas

        val listaParaExibir = if (mostrarApenasFavoritos) {
            listaBase.filter { receita -> prefs.getBoolean(receita.nome, false) }
        } else {
            listaBase
        }

        // Lógica para exibir a lista ou a mensagem de "Não há receitas"
        if (listaParaExibir.isEmpty()) {
            binding.rvReceitas.visibility = View.GONE
            binding.txtVazio.visibility = View.VISIBLE
        } else {
            binding.rvReceitas.visibility = View.VISIBLE
            binding.txtVazio.visibility = View.GONE
        }

        // Recria o adapter com a lista correta (todas ou favoritas)
        val adapter = ReceitaAdapter(listaParaExibir) { receitaClicada ->
            val intent = Intent(this, DetalheActivity::class.java)
            intent.putExtra(DetalheActivity.EXTRA_RECEITA, receitaClicada)
            startActivity(intent)
        }
        binding.rvReceitas.adapter = adapter
    }
}