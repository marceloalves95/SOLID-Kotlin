package ocp.errado

/**
 * @author RubioAlves
 * Created 13/06/2021 at 11:02
 */
class OcpErrado {

    open class Funcionario{

        open fun salario(): Double = 1700.0

    }
    class ContratoClt:Funcionario(){

        override fun salario():Double = 2000.0
    }
    class Estagio:Funcionario(){

        fun bolsaAuxilio():Double = 500.0
        override fun salario():Double = 1000.0+bolsaAuxilio()
    }

    class FolhaDePagamento{

        private var saldo:Double = 0.0

        fun calcular(funcionario: Funcionario){

            if (funcionario is ContratoClt){
                saldo = funcionario.salario()
                println(saldo)
            }
            else if (funcionario is Estagio){
                saldo = funcionario.bolsaAuxilio()
                println(saldo)
            }
        }
    }

}
