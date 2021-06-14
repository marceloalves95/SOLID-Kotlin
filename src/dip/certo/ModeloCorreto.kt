package dip.certo

/**
 * @author RubioAlves
 * Created 13/06/2021 at 13:21
 */
class ModeloCorreto {

    interface Tool{

        fun cutterArm()
        //Example
        //fun knifeArm()
    }

    class Robot{

        fun print() = println("I cut with any tool given to me")

        class Cutter(private val tool:Tool){

            fun cutPizza() = tool.cutterArm()
            //Example
            //fun cutPizza() = tool.knifeArm()

        }
    }

}
