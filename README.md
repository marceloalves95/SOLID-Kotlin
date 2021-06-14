# SOLID-Kotlin
Projeto de estudo baseado nos principais conceitos sobre o SOLID.

![](src/imagens/SOLID.png)

## O que é o SOLID?

> O SOLID são cinco princípios da programação orientada a objetos que facilitam no desenvolvimento de softwares, tornando-os fáceis de manter e estender. Esses princípios podem ser aplicados a qualquer linguagem de POO.

## Por que é tão importante aprender esses conceitos?

É importante porque esses princípios são a base para vários Padrões e Projetos e tornam softwares mais evolutivos, de fácil manutenção e facilita mudanças necessárias após a finalização do projeto, não impactando em outras áreas do programa. De fato, podemos afirmar que um software que não segue tais princípios é um software mal escrito e de má qualidade. 

## Os princípios do SOLID

1. S **— Single Responsiblity Principle** (Princípio da Responsabilidade Única)
2. O **— Open-Closed Principle** (Princípio Aberto-Fechado)
3. L **— Liskov Substitution Principle** (Princípio da Substituição de Liskov)
4. I **— Interface Segregation Principle** (Princípio da Segregação da Interface)
5. D **— Dependency Inversion Principle** (Princípio da Inversão da Dependência)

## O que você deve ou não fazer

**Outros Exemplos:**

| **Princípios** | **O que você NÃO deve fazer**🚫 | **O que você DEVE fazer**✅ |
| :------------: | :----------------------------: | :------------------------: |
|     **S**      |             Errado             |           Certo            |
|     **O**      |             Errado             |           Certo            |
|     **L**      |             Errado             |           Certo            |
|     **I**      |             Errado             |           Certo            |
|     **D**      |             Errado             |           Certo            |

## Single Responsibility Principle 

> Princípio da Responsabilidade Única — ***Uma classe deve ter um, e somente um, motivo para mudar***.

![](src/imagens/SRP.png)

Esse princípio declara que uma classe deve ser especializada em um único assunto e possuir apenas uma responsabilidade dentro do software, ou seja, a classe deve ter uma única tarefa ou ação para executar.

Indo um pouco mais fundo, podemos dizer que para o sistema esteja de acordo com esse princípio, cada responsabilidade deve ser uma classe e cada classe deve ter uma única responsabilidade.

**Veja um exemplo:**

```kotlin
class ModeloErrado {

    class Robot{

        fun chef(){/*...*/}
        fun gardener(){/*...*/}
        fun painter(){/*...*/}
        fun driver(){/*...*/}

    }

}
```

A classe *Pedido* viola o Single Responsiblity Principle (SRP) porque realiza 3 tipos distintos de tarefas. Além de lidar com as informações do pedido, ela também é responsável pela exibição e manipulação dos dados. Lembre-se, o princípio da responsabilidade única preza que *uma classe deve ter um, e somente um, motivo para mudar***.**

```kotlin
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
```

## Open-Closed Principle 

> Princípio do Aberto-Fechado — ***Você deve ser capaz de estender um comportamento de uma classe sem a necessidade de modificá-lo***.

![](src/imagens/OCP.png)

```kotlin
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
```



```kotlin
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
```

## Liskov Substitution Principle

> Princípio da Substituição de Liskov — ***As classes derivadas devem ser substituíveis por suas classes bases***.

![](src/imagens/LSP.png)

```kotlin
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
```



```kotlin
class ModeloCorreto {

    open class RobotSam{

        open fun serveCoffee() = println("Here´s your coffee")

    }
    class RobotEden: RobotSam() {

        override fun serveCoffee() = println("Here´s a cappuccino")

    }

}
```

## Interface Segregation Principle 

> Princípio da Segregação de Interfaces — ***Muitas interfaces específicas são melhores do que uma interface única geral***.

![](src/imagens/ISP.png)

```kotlin
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
```



```kotlin
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
```

## Dependency Inversion Principle

> Princípio da Inversão de Dependência — ***Dependa de abstrações e não de implementações***.

![](src/imagens/DIP.png)

```kotlin
class ModeloErrado {

    class Robot{

        private val cutterArm:CutterArm = CutterArm()

        fun cutPizza(){
            cutterArm.cut()
            println("I cut pizza with my pizza cutter arm")
        }

    }
    class CutterArm{

        fun cut(){}

    }

}
```

No exemplo, podemos perceber que além de quebrar outros princípios do SOLID, a classe concreta *Interruptor* depende de uma outra classe concreta *Ventilador*. O Interruptor deveria ser capaz de acionar qualquer dispositivo independente de ser um ventilador uma lâmpada ou até mesmo um carro.

```kotlin
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
```

## Fontes

1. https://medium.com/desenvolvendo-com-paixao/o-que-%C3%A9-solid-o-guia-completo-para-voc%C3%AA-entender-os-5-princ%C3%ADpios-da-poo-2b937b3fc530
2. https://medium.com/thiago-aragao/solid-princ%C3%ADpios-da-programa%C3%A7%C3%A3o-orientada-a-objetos-ba7e31d8fb25
3. https://medium.com/backticks-tildes/the-s-o-l-i-d-principles-in-pictures-b34ce2f1e898
