package dip.exemplos

class EquipamentosEletricos {

    /*
    No exemplo, podemos perceber que além de quebrar outros princípios do SOLID,
    a classe concreta Interruptor depende de uma outra classe concreta (Ventilador).
    O Interruptor deveria ser capaz de acionar qualquer dispositivo independente de
    ser um ventilador uma lâmpada ou até mesmo um carro.
    */

    class Interruptor {

        private val ventilador: Ventilador = Ventilador()

        fun acionar() {
            if (ventilador.ligado()) ventilador.ligar() else ventilador.desligar()
        }
    }

    class Ventilador {

        fun ligado(): Boolean = true
        fun ligar() {}
        fun desligar() {}
    }
}