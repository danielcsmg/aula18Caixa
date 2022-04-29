package exercicio2

class Pessoa(
    private var diaNasc: Int,
    private var mesNasc: Int,
    private var anoNasc: Int
) {
    private val diaHoje = 28
    private val mesHoje = 4
    private val anoHoje = 2022
    private var idade: Int = 0

    init {
        calcularIdade()
    }

    private fun calcularIdade(): Int {
        idade = if (mesNasc < mesHoje) {
            anoHoje - anoNasc
        } else if (mesNasc == mesHoje && diaNasc <= diaHoje) {
            anoHoje - anoNasc
        } else {
            anoHoje - anoNasc - 1
        }
        return idade
    }

    fun informarIdade() {
        println("Idade é: $idade")
    }

    fun ajustarDataDeNascimento(dia: Int, mes: Int, ano: Int) {
        diaNasc = dia
        mesNasc = mes
        anoNasc = ano
        calcularIdade()
    }
    companion object AlgumaCoisa{
        fun helloWorld(){
            println("Hello World!")
        }
    }
}