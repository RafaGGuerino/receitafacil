package com.rafagguerino.receitafacil.data

import com.rafagguerino.receitafacil.R
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
            observacao = "Cobertura de chocolate é opcional.",
            imagemRes = R.drawable.bolo_de_cenoura
        ),
        Receita(
            id = 2,
            nome = "Omelete Simples",
            categoria = "Café da manhã",
            tempoPreparoMin = 10,
            ingredientes = listOf("2 ovos", "Sal a gosto", "1 fio de azeite"),
            modoPreparo = "Bata os ovos com sal e despeje na frigideira aquecida com azeite. Dobre ao meio quando firmar.",
            imagemRes = R.drawable.omelete
        ),
        Receita(
            id = 3,
            nome = "Macarrão ao Alho e Óleo",
            categoria = "Almoço",
            tempoPreparoMin = 20,
            ingredientes = listOf("250 g de espaguete", "4 dentes de alho", "Azeite", "Sal", "Salsinha"),
            modoPreparo = "Cozinhe o macarrão. Doure o alho no azeite, misture ao macarrão e finalize com salsinha.",
            observacao = "Pimenta calabresa combina bem.",
            imagemRes = R.drawable.macarrao_alho_oleo
        ),
        Receita(
            id = 4,
            nome = "Filé à Parmegiana de Mignon",
            categoria = "Almoço",
            tempoPreparoMin = 45,
            ingredientes = listOf("500g de filé mignon em bifes", "Farinha de trigo para empanar", "Farinha de rosca para empanar", "2 ovos batidos", "300ml de molho de tomate", "200g de queijo muçarela", "Sal e pimenta a gosto"),
            modoPreparo = "Tempere os filés com sal e pimenta. Empane passando na farinha de trigo, nos ovos e na farinha de rosca. Frite em óleo quente. Coloque em uma travessa, cubra com molho e queijo, e leve ao forno para gratinar.",
            observacao = "Fica excelente servido com arroz branco e batatas fritas.",
            imagemRes = R.drawable.file_parmegiana
        ),
        Receita(
            id = 5,
            nome = "Strogonoff de Frango",
            categoria = "Almoço",
            tempoPreparoMin = 30,
            ingredientes = listOf("500g de peito de frango em cubos", "1 cebola picada", "1 dente de alho", "1 caixa de creme de leite", "3 colheres de ketchup", "1 colher de mostarda", "100g de champignon"),
            modoPreparo = "Doure a cebola, o alho e o frango na panela. Adicione a mostarda e o ketchup. Desligue o fogo, misture o creme de leite e o champignon.",
            observacao = "Sirva acompanhado de batata palha.",
            imagemRes = R.drawable.strogonoff_frango
        ),
        Receita(
            id = 6,
            nome = "Pão de Queijo",
            categoria = "Lanche",
            tempoPreparoMin = 40,
            ingredientes = listOf("500g de polvilho doce", "1 xícara de leite", "1/2 xícara de óleo", "2 ovos", "250g de queijo meia cura ralado", "Sal a gosto"),
            modoPreparo = "Ferva o leite com o óleo e o sal. Jogue sobre o polvilho para escaldar e misture. Quando amornar, adicione os ovos e o queijo. Faça bolinhas e asse a 180°C por cerca de 30 minutos.",
            imagemRes = R.drawable.pao_de_queijo
        ),
        Receita(
            id = 7,
            nome = "Brigadeiro Tradicional",
            categoria = "Sobremesa",
            tempoPreparoMin = 15,
            ingredientes = listOf("1 lata de leite condensado", "3 colheres de chocolate em pó", "1 colher de manteiga", "Chocolate granulado para confeitar"),
            modoPreparo = "Em uma panela, misture o leite condensado, o chocolate em pó e a manteiga. Leve ao fogo baixo, mexendo sempre, até desgrudar do fundo da panela. Deixe esfriar, faça bolinhas e passe no granulado.",
            observacao = "Unte as mãos com um pouco de manteiga para facilitar na hora de enrolar.",
            imagemRes = R.drawable.brigadeiro
        ),
        Receita(
            id = 8,
            nome = "Escondidinho de Carne Seca",
            categoria = "Jantar",
            tempoPreparoMin = 50,
            ingredientes = listOf("1 kg de mandioca cozida e amassada", "500 g de carne seca dessalgada, cozida e desfiada", "1 cebola picada", "2 colheres de sopa de manteiga", "1/2 xícara de leite", "150 g de queijo muçarela ralado"),
            modoPreparo = "Refogue a carne seca desfiada com a cebola. Em uma panela, misture a mandioca, a manteiga e o leite em fogo baixo até formar um purê liso. Em um refratário, coloque metade do purê, adicione o recheio de carne e cubra com o restante do purê. Finalize com o queijo e leve ao forno a 200°C por 15 minutos para gratinar.",
            observacao = "Pode substituir a carne seca por frango desfiado ou carne moída.",
            imagemRes = R.drawable.escondidinho_carne_seca
        )
    )
}