package com.rafagguerino.receitafacil.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafagguerino.receitafacil.data.FavoritosStorage
import com.rafagguerino.receitafacil.data.ReceitasMock
import com.rafagguerino.receitafacil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mostrarApenasFavoritos = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.ajustarInsets(binding.root)

        binding.rvReceitas.layoutManager = LinearLayoutManager(this)

        // Alterna entre "Todas" e "Favoritas"
        binding.toggleFiltro.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (isChecked) {
                mostrarApenasFavoritos = checkedId == binding.btnFavoritas.id
                atualizarLista()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // Atualiza a lista ao voltar do detalhe (o favorito pode ter mudado)
        atualizarLista()
    }

    private fun atualizarLista() {
        val listaBase = ReceitasMock.receitas

        val listaParaExibir = if (mostrarApenasFavoritos) {
            listaBase.filter { FavoritosStorage.isFavorito(this, it.id) }
        } else {
            listaBase
        }

        // Mostra a lista ou a mensagem de "Não há receitas curtidas"
        val vazia = listaParaExibir.isEmpty()
        binding.rvReceitas.visibility = if (vazia) View.GONE else View.VISIBLE
        binding.txtVazio.visibility = if (vazia) View.VISIBLE else View.GONE

        binding.rvReceitas.adapter = ReceitaAdapter(listaParaExibir) { receitaClicada ->
            val intent = Intent(this, DetalheActivity::class.java)
            intent.putExtra(DetalheActivity.EXTRA_RECEITA, receitaClicada)
            startActivity(intent)
        }
    }
}
