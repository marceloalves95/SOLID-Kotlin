package isp.exemplos

class AnimaisqueVoamouNaoVoam{

    interface Aves{
        fun voar()
    }
    class Papagaio:Aves{
        override fun voar(){/*...*/}
    }

    /*
    A classe Pinguim é uma ave que não voa.
    A Interface Aves está forçando a Classe Pinguim a implementar esse método.
    Isso viola o príncipio do ISP e do LSP também.
    */

    class Pinguim:Aves{
        override fun voar(){/*...*/}
    }
}