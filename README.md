# Receita Fácil

Aplicativo Android de receitas culinárias, desenvolvido como trabalho parcial da disciplina **Mobile 1** (Android Views com XML, navegação e Intent).

## Objetivo do aplicativo

O Receita Fácil permite consultar uma lista de receitas, ver os detalhes de cada uma (ingredientes, modo de preparo e observação) e marcar as preferidas como **favoritas**. A lista pode ser filtrada entre **Todas** e **Favoritas**.

Os dados são **simulados (mock)**: não há API, banco de dados nem chaves/senhas. Apenas os favoritos são salvos no próprio aparelho (SharedPreferences).

## Funcionalidades

- **Tela de lista:** receitas em cards (imagem, nome, categoria e tempo de preparo), com filtro *Todas / Favoritas* e mensagem "Não há receitas favoritas" quando não há favoritas.
- **Tela de detalhe:** foto, título, categoria e tempo, ingredientes, modo de preparo e observação (a seção só aparece quando a receita tem observação).
- **Favoritar:** botão flutuante (estrela) que adiciona/remove a receita dos favoritos, exibe uma mensagem (Snackbar) e mostra o selo ★ na receita. O selo aparece na lista e no detalhe.
- O estado dos favoritos é mantido ao fechar e reabrir o app.

## Como os Requisitos são atendidos

| Requisito | Onde está |
|---|---|
| Duas telas em Android Views (XML) | `MainActivity` (`activity_main.xml`) e `DetalheActivity` (`activity_detalhe.xml`), com `LinearLayout`, `FrameLayout`, `ConstraintLayout`, `ScrollView`, `RecyclerView`, `TextView` e `ImageView` |
| Navegação por Intent explícita com dados | `MainActivity` abre a `DetalheActivity` com `putExtra`, enviando a `Receita` selecionada |
| ViewBinding | Todas as telas, o adapter e o componente do logo usam ViewBinding (sem `findViewById`) |
| Interação que atualiza a interface | Filtro Todas/Favoritas e botão de favoritar |
| Modelos imutáveis e opcionais | `data class Receita` com `val` e campos opcionais (`observacao: String?`, `imagemRes: Int?`) tratados com `?.let` e `isNullOrBlank()` |
| Dados simulados | `ReceitasMock.kt` |
| Componente XML reutilizável (opcional) | `view_logo_topo.xml`, inflado em `LogoTopo.kt` e usado na barra superior das duas telas |

## Estrutura do projeto

```
app/src/main/java/com/rafagguerino/receitafacil/
├── data/
│   ├── ReceitasMock.kt        # lista de receitas simuladas
│   └── FavoritosStorage.kt    # salva/consulta favoritos (SharedPreferences)
├── model/
│   └── Receita.kt             # data class Receita
└── ui/
    ├── MainActivity.kt        # lista + filtro
    ├── DetalheActivity.kt     # detalhe da receita + favoritar
    ├── ReceitaAdapter.kt      # adapter do RecyclerView
    ├── LogoTopo.kt            # logo na barra superior
    └── Insets.kt              # ajuste de barras do sistema (status/gestos)
```

## Como rodar o projeto localmente

### Pré-requisitos

- **Android Studio** em versão recente (que suporte o Android Gradle Plugin 9.4.1 e Gradle 9.6).
- **Conexão com a internet** na primeira abertura, para o Gradle baixar as dependências e o JDK 25 (configurado como toolchain do projeto).
- Um **emulador** (ex.: Pixel 6) ou um celular Android com **Android 7.0 (API 24) ou superior**.

### Passo a passo

1. Clone o repositório:
   ```bash
   git clone <LINK-DO-REPOSITORIO>
   ```
2. Abra o Android Studio e escolha **File > Open**, selecionando a pasta do projeto.
3. Aguarde o **Gradle Sync** terminar (na primeira vez pode demorar alguns minutos).
4. Crie ou selecione um emulador em **Device Manager** (ou conecte um celular com depuração USB ativada).
5. Selecione a configuração **app** e clique em **Run ▶**.

Não é necessário nenhum arquivo `.env`, chave de API ou configuração extra.

### Rodando pelo terminal (opcional)

```bash
./gradlew assembleDebug        # Linux/macOS
gradlew.bat assembleDebug      # Windows
```

O APK é gerado em `app/build/outputs/apk/debug/`.

## Bibliotecas utilizadas

Não há bibliotecas de terceiros. Todas são oficiais do Android/Google:

| Biblioteca | Para que serve |
|---|---|
| **AndroidX AppCompat** | Base das Activities e da barra superior (`AppCompatActivity`, `ActionBar`) |
| **AndroidX Core KTX** | Extensões Kotlin para APIs do Android (ex.: `updatePadding`, `edit` do SharedPreferences) |
| **AndroidX Activity KTX** | Extensões Kotlin para Activities |
| **AndroidX ConstraintLayout** | Layout dos cards da lista |
| **AndroidX RecyclerView** | Lista de receitas com reaproveitamento de itens |
| **Material Components** | Card, botão flutuante, grupo de botões do filtro, Snackbar e tema |
| **JUnit / Espresso** | Apenas para testes (não fazem parte do app) |
