package com.rafagguerino.receitafacil.ui

import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.rafagguerino.receitafacil.databinding.ViewLogoTopoBinding

/** Troca o título "Receita Facil" da barra superior pela logo, centralizada. */
fun AppCompatActivity.exibirLogoNoTopo() {
    val actionBar = supportActionBar ?: return
    val logo = ViewLogoTopoBinding.inflate(layoutInflater)

    val alturaPx = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 48f, resources.displayMetrics
    ).toInt()

    actionBar.setDisplayShowTitleEnabled(false)
    actionBar.setDisplayShowCustomEnabled(true)
    actionBar.setCustomView(
        logo.root,
        ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, alturaPx, Gravity.CENTER)
    )
}