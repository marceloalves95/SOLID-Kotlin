package isp.exemplos

class AnimaiscomAsas{

    interface Aves{/*...*/}
    interface AvesQueVoam:Aves{
        fun voar()
    }
    class Papagaio:AvesQueVoam{
        override fun voar(){/*...*/}
    }
    class Pinguim:Aves{/*...*/}
}