package ocp.certo

/**
 * @author RubioAlves
 * Created 13/06/2021 at 11:02
 */
class ModeloCorreto {

    interface Work{
        fun paint()
        fun cut()
    }

    class Robot:Work{

        override fun cut(){/*...*/}
        override fun paint(){/*...*/}

        fun print() = println("Now, I can cut & paint")

    }

}

