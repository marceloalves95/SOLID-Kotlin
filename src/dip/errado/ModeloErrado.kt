package dip.errado

/**
 * @author RubioAlves
 * Created 13/06/2021 at 13:20
 */
class ModeloErrado {

    class Robot{

        private val cutterArm:CutterArm = CutterArm()

        fun cutPizza() = cutterArm.cut()

    }

    class CutterArm{

        fun cut() = println("I cut pizza with my pizza cutter arm")

    }

}
