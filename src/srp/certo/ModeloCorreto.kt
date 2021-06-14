package srp.certo

/**
 * @author RubioAlves
 * Created 13/06/2021 at 10:53
 */
class ModeloCorreto {

    open class Robot{

        class Chef:Robot(){
            fun cook(){/*...*/}
        }
        class Gardener:Robot(){
            fun plant(){/*...*/}
        }
        class Painter:Robot(){
            fun paint(){/*...*/}
        }
        class Driver:Robot(){
            fun drive(){/*...*/}
        }

    }

}