package lsp.errado

/**
 * @author RubioAlves
 * Created 13/06/2021 at 11:54
 */
class ModeloErrado {

    open class RobotSam{

        open fun serveCoffee() = println("Here´s your coffee")

    }
    //A classe RobotEden é um subtipo da classe RobotSam.
    class RobotEden: RobotSam() {

        //Mais ele não serve café, somente água.
        override fun serveCoffee(){/*...*/}

        fun serveWater() = println("I can´t make coffee but here´s water")

    }

}