package ocp.errado

/**
 * @author RubioAlves
 * Created 13/06/2021 at 11:02
 */
class ModeloErrado {

    open class Robot{/*...*/}

    class Cutter:Robot(){
        fun cut(){/*...*/}
    }
    class Painter:Robot(){
        fun paint(){/*...*/}
    }

    class Work{

        fun working(robot:Robot){
            if(robot is Cutter) println("I can´t cut")
            else if (robot is Painter) println("Now, I can paint")

        }
    }
}

