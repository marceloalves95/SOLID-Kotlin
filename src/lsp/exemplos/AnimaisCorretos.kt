package lsp.exemplos

class AnimaisCorretos{

    open class Passaro{/*...*/}
    open class PassarosVoadores : Passaro() {
        open fun voar(){/*...*/}
    }

    class Pato : PassarosVoadores(){
        override fun voar(){/*...*/}
    }
    class Avestruz : Passaro()
}