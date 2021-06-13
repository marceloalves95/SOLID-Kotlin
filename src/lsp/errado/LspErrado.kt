package lsp.errado

/**
 * @author RubioAlves
 * Created 13/06/2021 at 11:54
 */
class LspErrado {

    open class Passaro {
        open fun voar(){/*...*/}
    }
    class Pato : Passaro(){
        override fun voar(){/*...*/}
    }
    //A classe Avestruz é um subtipo da classe Pássaro.
    class Avestruz : Passaro(){

        /*Avestruz é um pássaro, mas não pode voar.
        Isso significa que a classe Avestruz não deveria ser capaz de usar o método voar.
        Nesse caso, estamos quebrando o princípio do LSP.*/
        override fun voar(){/*...*/}

    }




}