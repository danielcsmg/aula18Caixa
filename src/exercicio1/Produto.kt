package exercicio1.exercicio1

class Produto(
    var codigo: Int,
    var nome: String,
    var preco: Double,
    var quantidade: Int
) {
    fun dadosDoProdutoCompras(){
        println("Código: $codigo")
        println("Nome: $nome")
        println("Preço: ${"%.2f".format(preco).replace(",", ".").toDouble()}")
        println("Quantidade de produtos: $quantidade")
    }
}