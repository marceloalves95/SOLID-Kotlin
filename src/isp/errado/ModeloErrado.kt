package isp.errado

/**
 * @author RubioAlves
 * Created 13/06/2021 at 12:59
 */
class ModeloErrado {

    interface Exercises{
        fun spinAround()
        fun rotateArms()
        fun wiggleAntennas()
    }
    class RobotWithAntennas:Exercises{

        override fun spinAround() {/*..*/}
        override fun rotateArms() {/*..*/}
        override fun wiggleAntennas() {/*..*/}

    }

    //A classe RobotNotAntennas é um robô mais não possui antenas.
    class RobotNotAntennas:Exercises{

        override fun spinAround() {/*..*/}
        override fun rotateArms() {/*..*/}

        //A Interface Exercises está forçando a Classe RobotNotAntennas a implementar esse método.
        //Isso viola o príncipio do Interface Segregation Principle e do Liskov Substitution Principle também.
        override fun wiggleAntennas() = println("Oops! But I don´t have antennas")


    }

}