package lsp.model

/**
 * @author RubioAlves
 * Created 13/06/2021 at 11:54
 */
class Modelo {

    // Meu nome é A
    val objetoA = A()
    // Meu nome é B
    val objetoB = B()

    open class A{
        open fun getNome(){
            println("meu nome é A")
        }
    }
    class B: A() {
        override fun getNome(){
            println("meu nome é B")
        }
    }

    fun imprimeNome(objeto: A) = objeto.getNome()


}
