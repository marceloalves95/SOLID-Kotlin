package dip.exemplos

class Dispositivos{

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

        fun adionarDispositivo() = dispositivo.acionar()

    }
}