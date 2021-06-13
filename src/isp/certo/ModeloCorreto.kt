package isp.certo

/**
 * @author RubioAlves
 * Created 13/06/2021 at 12:59
 */
class ModeloCorreto {

    interface Aves{/*...*/}
    interface AvesQueVoam:Aves{
        fun voar()
    }
    class Papagaio:AvesQueVoam{
        override fun voar(){/*...*/}
    }
    class Pinguim:Aves{/*...*/}
}