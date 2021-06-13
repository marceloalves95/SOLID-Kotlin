package ocp.certo

/**
 * @author RubioAlves
 * Created 13/06/2021 at 11:02
 */
class OcpCerto {

    interface Remuneravel{
        fun remuneracao():Double
    }

    class ContratoClt:Remuneravel {
        override fun remuneracao(): Double = 2000.0
    }
    class Estagio:Remuneravel{
        override fun remuneracao(): Double = 1200.0
    }
    class FolhaDePagamento{

        private var saldo:Double = 0.0

        fun calcular(funcionario:Remuneravel){
            saldo = funcionario.remuneracao()
            println(saldo)
        }

    }

}
