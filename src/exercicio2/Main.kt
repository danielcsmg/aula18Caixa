package exercicio2

fun main() {
    val pessoa = Pessoa(21, 5, 1994)
    pessoa.informarIdade()

    pessoa.ajustarDataDeNascimento(16, 8, 1983)
    pessoa.informarIdade()

    pessoa.ajustarDataDeNascimento(4, 1, 1643)
    pessoa.informarIdade()

    pessoa.ajustarDataDeNascimento(14, 3, 1879)
    pessoa.informarIdade()

}
