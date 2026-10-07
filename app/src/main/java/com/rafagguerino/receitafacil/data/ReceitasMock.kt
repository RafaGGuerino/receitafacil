package com.rafagguerino.receitafacil.data

import com.rafagguerino.receitafacil.model.Receita

object ReceitasMock {
    val receitas = listOf(
        Receita(
            id = 1,
            nome = "Bolo de Cenoura",
            categoria = "Sobremesa",
            tempoPreparoMin = 60,
            ingredientes = listOf("3 cenouras", "4 ovos", "1 xícara de óleo", "2 xícaras de açúcar", "2 xícaras de farinha", "1 colher de fermento"),
            modoPreparo = "Bata no liquidificador a cenoura, os ovos e o óleo. Misture com o açúcar e a farinha. Adicione o fermento e asse a 180°C por 40 minutos.",
            observacao = "Cobertura de chocolate é opcional."
        ),
        Receita(
            id = 2,
            nome = "Omelete Simples",
            categoria = "Café da manhã",
            tempoPreparoMin = 10,
            ingredientes = listOf("2 ovos", "Sal a gosto", "1 fio de azeite"),
            modoPreparo = "Bata os ovos com sal e despeje na frigideira aquecida com azeite. Dobre ao meio quando firmar."
            // observacao = null
        ),
        Receita(
            id = 3,
            nome = "Macarrão ao Alho e Óleo",
            categoria = "Almoço",
            tempoPreparoMin = 20,
            ingredientes = listOf("250 g de espaguete", "4 dentes de alho", "Azeite", "Sal", "Salsinha"),
            modoPreparo = "Cozinhe o macarrão. Doure o alho no azeite, misture ao macarrão e finalize com salsinha.",
            observacao = "Pimenta calabresa combina bem."
        )
    )
}