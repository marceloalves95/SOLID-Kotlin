package dip.certo

/**
 * @author RubioAlves
 * Created 13/06/2021 at 13:21
 */
class DipCerto {

    interface Dispositivo {
        fun acionar()
        fun ligado(): Boolean
        fun ligar()
        fun desligar()
    }

    class Ventilador : Dispositivo {

        override fun ligado(): Boolean = true
        override fun ligar() = println("Ligado")
        override fun desligar() = println("Desligado")
        override fun acionar() = if (ligado()) ligar() else desligar()

    }
    class Lampada:Dispositivo{

        override fun ligado(): Boolean = false
        override fun ligar() = println("Ligado")
        override fun desligar() = println("Desligado")

        override fun acionar() = if (ligado()) ligar() else desligar()

    }
    class Interruptor(private val dispositivo:Dispositivo){

        fun adionarDispositivo(){
            dispositivo.acionar()
        }

    }

}
