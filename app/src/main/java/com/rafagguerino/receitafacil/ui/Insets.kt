package com.rafagguerino.receitafacil.ui

import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding

/** Afasta o conteúdo da barra de status, da barra de ação e da barra de gestos. */
fun AppCompatActivity.ajustarInsets(root: View) {
    val tv = TypedValue()
    val alturaActionBar =
        if (theme.resolveAttribute(androidx.appcompat.R.attr.actionBarSize, tv, true)) {
            TypedValue.complexToDimensionPixelSize(tv.data, resources.displayMetrics)
        } else 0

    ViewCompat.setOnApplyWindowInsetsListener(root) { view, insets ->
        val barras = insets.getInsets(
            WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
        )
        view.updatePadding(
            left = barras.left,
            top = barras.top + alturaActionBar,
            right = barras.right,
            bottom = barras.bottom
        )
        insets
    }
}