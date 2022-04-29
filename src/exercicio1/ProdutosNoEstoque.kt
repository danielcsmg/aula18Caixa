package exercicio1

class ProdutosNoEstoque (
    var codigo: Int,
    var nome: String,
    var preco: Double
    ){


    fun dadosDoProduto(){
        println("Código: $codigo")
        println("Nome: $nome")
        println("Preço: ${"%.2f".format(preco).replace(",", ".").toDouble()}")
    }
}