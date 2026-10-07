package com.rafagguerino.receitafacil.data

import android.content.Context
import androidx.core.content.edit

object FavoritosStorage {
    private const val PREFS_FAVORITOS = "FavoritosPrefs"

    private fun prefs(context: Context) =
        context.getSharedPreferences(PREFS_FAVORITOS, Context.MODE_PRIVATE)

    private fun chave(id: Int) = "receita_$id"

    fun isFavorito(context: Context, id: Int): Boolean =
        prefs(context).getBoolean(chave(id), false)

    fun setFavorito(context: Context, id: Int, favorito: Boolean) {
        prefs(context).edit { putBoolean(chave(id), favorito) }
    }
}
