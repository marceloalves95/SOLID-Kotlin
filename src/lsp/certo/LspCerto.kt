package lsp.certo

/**
 * @author RubioAlves
 * Created 13/06/2021 at 12:11
 */
class LspCerto {

    open class Passaro{/*...*/}
    open class PassarosVoadores : Passaro() {
        open fun voar(){/*...*/}
    }

    class Pato : PassarosVoadores(){
        override fun voar(){/*...*/}
    }
    class Avestruz : Passaro()
}