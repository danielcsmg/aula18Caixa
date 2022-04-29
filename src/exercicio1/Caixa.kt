package exercicio1

import exercicio1.exercicio1.Produto
import kotlin.system.exitProcess

class Caixa {
    private var produtosCadastrados = ArrayList<ProdutosNoEstoque>()
    private var produtosVenda = ArrayList<Produto>()

    init {
        produtosBasicos()
        menu()
    }

    fun produtosBasicos(){
        produtosCadastrados.add(ProdutosNoEstoque(1, "Arrois", 20.50))
        produtosCadastrados.add(ProdutosNoEstoque(2, "Fejão", 6.50))
        produtosCadastrados.add(ProdutosNoEstoque(3, "Lidiói", 10.00))
        produtosCadastrados.add(ProdutosNoEstoque(4, "Pão di sar", 3.99))
        produtosCadastrados.add(ProdutosNoEstoque(5, "Mantega", 3.99))
        produtosCadastrados.add(ProdutosNoEstoque(6, "Quidicarne", 3.99))
        produtosCadastrados.add(ProdutosNoEstoque(7, "Lidileite", 3.99))
        produtosCadastrados.add(ProdutosNoEstoque(8, "Dusdiovo", 6.99))
    }

    fun cadastrarProdutos(){
        do {
            println("Adicionar novo produto? 's'im ou 'n'ão:")
            val opc = readln()
            if (opc == "s") {
                println("Adicionar o nome do produto:")
                val nomeProduto = readln()
                println("Digite o código do produto:")
                val codigoProduto = readln().toInt()
                println("Adicione o preço do produto:")
                val precoProduto = readln().toDouble()
                var verificador = false
                produtosCadastrados.forEachIndexed{_, prod ->
                    if(prod.codigo == codigoProduto){
                        verificador = true
                    }
                }
                if(verificador){
                    println("Código já está em uso.")
                }else {
                    produtosCadastrados.add(ProdutosNoEstoque(codigoProduto, nomeProduto, precoProduto))
                }
            }else if(opc == "n"){
                continue
            }else{
                println("Opção inválida!")
            }
        }while (opc != "n")
    }

    fun mostrarProdutosCadastrados(){
        if(produtosCadastrados.size == 0){
            println("Não há produtos cadastrados!")
        }else{
            println()
            println("--------##---###---##--------")
            println("Produtos em Estoque:")
            produtosCadastrados.forEach {
                it.dadosDoProduto()
                println("--------##---###---##--------")
                println()
            }
        }
    }

    fun vender(){
        do {
            println("Adicionar novo produto? 's'im ou 'n'ão:")
            val opc = readln()
            when(opc) {
                "s" -> {
                    println("Adicionar o código do produto a ser comprado:")
                    val codProduto = readln().toInt()
                    var emEstoque = false
                    produtosCadastrados.forEach {
                        if (codProduto == it.codigo) {
                            emEstoque = true
                            println("Digite a quantidade do produto ${it.nome.uppercase()} que serão comprados:")
                            val qtdVenda = readln().toInt()
                            produtosVenda.add(Produto(it.codigo, it.nome, it.preco, qtdVenda))
                        }
                    }
                    if (!emEstoque) {
                        println("Produto inexistente!")
                    }
                }
                "n" -> continue
                else -> println("Opção inválida!")
            }
        }while (opc != "n")
    }

    fun mostrarVendaETotal(): Double {
        var totalCompras = 0.0
        println()
        println("--------##---###---##--------")
        println("Produtos da compra:")
        produtosVenda.forEach {
            it.dadosDoProdutoCompras()
            println("--------##---###---##--------")
            println()
            totalCompras += (it.preco * it.quantidade)
        }
        return "%.2f".format(totalCompras).replace(",", ".").toDouble()
    }

    fun menu(){
        println()
        println()
        println("--------MENU---------")
        println("Para cadastrar novos produtos do estoque: 'c'")
        println("Para continuar venda: 'continuar'")
        println("Para mostrar última venda: 'mv'")
        println("Para mostrar lista de produtos cadastrados: 'm'")
        println("Para nova venda: 'v'")
        println("Para mostrar sair: 'sair'")
        when(readln()){
            "c", "cadastra" -> {
                this.cadastrarProdutos()
                menu()
            }
            "continuar" -> {
                this.vender()
                println("O total de compras é de ${this.mostrarVendaETotal()}.")
                menu()
            }
            "m", "mostrar" -> {
                this.mostrarProdutosCadastrados()
                menu()
            }
            "v", "vender" -> {
                produtosVenda = ArrayList()
                this.vender()
                println("O total de compras é de ${this.mostrarVendaETotal()}.")
                menu()
            }
            "sair" -> {
                println("Até mais!!!")
                exitProcess(0)
            }
            "mv" -> {
                println("O total de compras é de ${this.mostrarVendaETotal()}.")
                menu()
            }
            else -> {
                println("Opção incorreta!")
                menu()
            }
        }
    }

    companion object Supermercado{
        fun boasVindas(){
            println("Bem vindo ao Supermercado Mineiro!")
            println("Este é seu sistema de Caixa.")
            println("----------------------------")
            println()
        }
    }
}