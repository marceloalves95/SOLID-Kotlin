package lsp.certo

/**
 * @author RubioAlves
 * Created 13/06/2021 at 12:11
 */
class ModeloCorreto {

    open class RobotSam{

        open fun serveCoffee() = println("Here´s your coffee")

    }
    class RobotEden: RobotSam() {

        override fun serveCoffee() = println("Here´s a cappuccino")

    }

}
