package com.rafagguerino.receitafacil.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafagguerino.receitafacil.R
import com.rafagguerino.receitafacil.data.FavoritosStorage
import com.rafagguerino.receitafacil.databinding.ItemReceitaBinding
import com.rafagguerino.receitafacil.model.Receita

class ReceitaAdapter(
    private val receitas: List<Receita>,
    private val onItemClick: (Receita) -> Unit
) : RecyclerView.Adapter<ReceitaAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemReceitaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemReceitaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val receita = receitas[position]
        with(holder.binding) {
            txtTituloReceita.text = receita.nome
            txtDetalhesBasicos.text = root.context.getString(
                R.string.detalhes_basicos,
                receita.categoria,
                receita.tempoPreparoMin
            )
            receita.imagemRes?.let { imgReceita.setImageResource(it) }

            // Selo de "curtida" visível só para favoritas
            val curtida = FavoritosStorage.isFavorito(root.context, receita.id)
            txtSeloCurtida.visibility = if (curtida) View.VISIBLE else View.GONE

            root.setOnClickListener { onItemClick(receita) }
        }
    }

    override fun getItemCount() = receitas.size
}
