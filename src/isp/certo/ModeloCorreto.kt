package isp.certo

/**
 * @author RubioAlves
 * Created 13/06/2021 at 12:59
 */
class ModeloCorreto {

    interface Exercices{/*...*/}

    interface CanSpinAround:Exercices{
        fun spinAround()
    }
    interface CanRotateArms:Exercices{
        fun rotateArms()
    }
    interface CanWiggleAntennas:Exercices{
        fun wiggleAntennas()
    }

    class RobotWithAntennas:CanRotateArms, CanSpinAround, CanWiggleAntennas{

        override fun spinAround() {/*...*/}
        override fun rotateArms() {/*...*/}
        override fun wiggleAntennas() {/*...*/}

        fun print() = println("Awesome!")

    }
    class RobotNotAntennas:CanRotateArms, CanSpinAround{

        override fun spinAround() {/*...*/}
        override fun rotateArms() {/*...*/}

        fun print() = println("Awesome!")

    }

}