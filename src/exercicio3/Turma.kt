package exercicio3

class Turma {
    private var alunos = ArrayList<Aluno>()

    init {
        getInformacoes()
    }

    private fun cadastrar(){
        println("Digite o nome do aluno:")
        val nomeAluno = readln()
        val aluno = Aluno(nomeAluno)
        alunos.add(aluno)
    }

    private fun mostrarInformacoes(){
        println("Informações da turma:")
        alunos.forEach{
            it.mostrarInformacoes()
        }
    }

    private fun getInformacoes(){
        cadastrar()
        println("Vamos cadastrar os alunos!")
        var opc = "sim"
        while (true){
            when (opc) {
                "sim" -> {
                    cadastrar()
                }
                "não" -> {
                    mostrarInformacoes()
                    break
                }
                else -> {
                    println("Opção inválida!")
                }
            }
            println("Deseja fazer novo cadastro? sim ou não:")
            opc = readln()
        }
    }

    fun mediaDaTurma(){
        var mediaTurma = 0.0
        alunos.forEach{
            mediaTurma += it.calcularMedia()
        }
        println("Média da turma: ${mediaTurma / alunos.size}")
    }
}