package exercicio3

class Aluno(nomeAluno: String) {
    private var nome = nomeAluno
    private var notas = Array(4){0.0}

    init {
        getNotas()
    }

    private fun getNotas(){
        notas.forEachIndexed{ i, _ ->
            println("Digite a ${i+1}ª nota:")
            notas[i] = readln().toDouble()
            while(notas[i] !in 0.0..10.0){
                println("Nota inválida!")
                println("Digite a ${i+1}ª nota novamente:")
                notas[i] = readln().toDouble()
            }
        }
    }

    fun calcularMedia(): Double{
        var soma = 0.0
        notas.forEach {
            soma += it
        }
        return soma / notas.size
    }

    fun mostrarInformacoes(){
        println("Aluno: $nome")
        notas.forEachIndexed { i, nota ->
            println("Nota ${i+1}: $nota")
        }
        println("Média do aluno: ${calcularMedia()}")
        println("---------###----------")
        println()
    }
}