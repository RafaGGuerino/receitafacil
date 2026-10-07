package com.rafagguerino.receitafacil.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafagguerino.receitafacil.data.ReceitasMock
import com.rafagguerino.receitafacil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvReceitas.layoutManager = LinearLayoutManager(this)
        binding.rvReceitas.adapter = ReceitaAdapter(ReceitasMock.receitas) { receita ->
            val intent = Intent(this, DetalheActivity::class.java).apply {
                putExtra(DetalheActivity.EXTRA_RECEITA, receita)
            }
            startActivity(intent)
        }
    }
}