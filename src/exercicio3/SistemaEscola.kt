package exercicio3

import kotlin.system.exitProcess

class SistemaEscola {
    private val turmas: ArrayList<Turma> = ArrayList()

    init {
        menu()
    }

    private fun getTurma() {
        var opc = "sim"
        while (true) {
            when (opc) {
                "sim" -> {
                    val turma = Turma()
                    this.turmas.add(turma)
                }
                "não" -> {
                    break
                }
                else -> {
                    println("Opção inválida!")
                }
            }
            println("Deseja cadastrar uma turma? sim ou não:")
            opc = readln()
        }
    }

    private fun mostrarTurmas() {
        turmas.forEachIndexed { i, it ->
            println("Turma ${i + 1}:")
            it.mediaDaTurma()
        }
    }

    private fun menu() {
        boasVindas()
        var opc = "c"
        do {
            when(opc){
                "c" -> getTurma()
                "m" -> mostrarTurmas()
                "s" -> exitProcess(0)
                "menu" -> menuOpcoes()
            }
            println("Digite uma opção.")
            println("Digite 'menu' para acessar o menu:")
            opc = readln().lowercase()
        } while (true)

    }

    private fun menuOpcoes(){
        println("'c' para cadastrar")
        println("'m' para mostrar as as médias das turmas.")
        println("'c' para cadastrar")
        println("'s' para sair.")
    }

    companion object SistemaSimCity {
        fun boasVindas() {
            println("---SISTEMA DE NOTAS SIMCITY---")
        }
    }
}

