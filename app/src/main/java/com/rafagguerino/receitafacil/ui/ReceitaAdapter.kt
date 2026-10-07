package com.rafagguerino.receitafacil.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
            // Referências atualizadas de acordo com o novo layout Material Design
            txtTituloReceita.text = receita.nome
            txtDetalhesBasicos.text = "${receita.categoria} • ${receita.tempoPreparoMin} min"
            receita.imagemRes?.let { imgReceita.setImageResource(it) }

            root.setOnClickListener { onItemClick(receita) }
        }
    }

    override fun getItemCount() = receitas.size
}