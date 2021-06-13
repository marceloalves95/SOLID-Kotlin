# SOLID-Kotlin
Projeto de estudo baseado nos principais conceitos sobre o SOLID.

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

| **Princípios** | **O que você NÃO deve fazer**🚫 | **O que você DEVE fazer**✅ |
| :------------: | :----------------------------: | :------------------------: |
|     **S**      |             Errado             |           Certo            |
|     **O**      |             Errado             |           Certo            |
|     **L**      |             Errado             |           Certo            |
|     **I**      |             Errado             |           Certo            |
|     **D**      |             Errado             |           Certo            |

## Single Responsiblity Principle 

> Princípio da Responsabilidade Única — ***Uma classe deve ter um, e somente um, motivo para mudar***.

![](src/imagens/SRP.png)

Esse princípio declara que uma classe deve ser especializada em um único assunto e possuir apenas uma responsabilidade dentro do software, ou seja, a classe deve ter uma única tarefa ou ação para executar.

Indo um pouco mais fundo, podemos dizer que para o sistema esteja de acordo com esse princípio, cada responsabilidade deve ser uma classe e cada classe deve ter uma única responsabilidade.

**Veja um exemplo:**

```kotlin
class ModeloErrado {

    class Pedido{
        
        //Informações do Pedido
        fun calculateTotalSum(){/*...*/}
        fun getItems(){/*...*/}
        fun getItemCount(){/*...*/}
        fun addItem(item:String){/*...*/}
        fun deleteItem(){/*...*/}

        //Exibição do Pedido
        fun printOrder(){/*...*/}
        fun showOrder(){/*...*/}

        //Manipulação do Pedido
        fun load(){/*...*/}
        fun save(){/*...*/}
        fun update(){/*...*/}
        fun delete(){/*...*/}
    }
    
}
```

A classe *Pedido* viola o Single Responsiblity Principle (SRP) porque realiza 3 tipos distintos de tarefas. Além de lidar com as informações do pedido, ela também é responsável pela exibição e manipulação dos dados. Lembre-se, o princípio da responsabilidade única preza que *uma classe deve ter um, e somente um, motivo para mudar***.**

```kotlin
class ModeloCorreto {

    class Pedido(){
        fun calculateTotalSum(){/*...*/}
        fun getItems(){/*...*/}
        fun getItemCount(){/*...*/}
        fun addItem(item:String){/*...*/}
        fun deleteItem(item:String){/*...*/}
    }

    class PedidoRepository(){
        fun load(pedidoID:Int){/*...*/}
        fun save(pedido:Pedido){/*...*/}
        fun update(pedido:Pedido){/*...*/}
        fun delete(pedido:Pedido){/*...*/}
    }

    class PedidoView(){
        fun printOrder(pedido:Pedido){/*...*/}
        fun showOrder(pedido:Pedido){/*...*/}
    }

}
```

## Open-Closed Principle 

> Princípio do Aberto-Fechado — ***Você deve ser capaz de estender um comportamento de uma classe sem a necessidade de modificá-lo***.

![]()

```kotlin
class ModeloErrado {

    open class Funcionario{
        open fun salario(): Double = 1700.0
    }
    class ContratoClt:Funcionario(){
        override fun salario():Double = 2000.0
    }
    class Estagio:Funcionario(){
        fun bolsaAuxilio():Double = 500.0
        override fun salario():Double = 1000.0+bolsaAuxilio()
    }
    
    class FolhaDePagamento{

        private var saldo:Double = 0.0

        fun calcular(funcionario: Funcionario){

            if (funcionario is ContratoClt){
                saldo = funcionario.salario()
                println(saldo)
            }
            else if (funcionario is Estagio){
                saldo = funcionario.bolsaAuxilio()
                println(saldo)
            }
        }
    }

}
```



```kotlin
class ModeloCorreto {

    interface Remuneravel{
        fun remuneracao():Double
    }

    class ContratoClt:Remuneravel {
        override fun remuneracao(): Double = 2000.0
    }
    class Estagio:Remuneravel{
        override fun remuneracao(): Double = 1200.0
    }
    class FolhaDePagamento{

        private var saldo:Double = 0.0

        fun calcular(funcionario:Remuneravel){
            saldo = funcionario.remuneracao()
            println(saldo)
        }

    }

}
```

## Liskov Substitution Principle

> Princípio da Substituição de Liskov — ***As classes derivadas devem ser substituíveis por suas classes bases***.

![]()

```kotlin
class ModeloErrado {

    open class Passaro {
        open fun voar(){/*...*/}
    }
    class Pato : Passaro(){
        override fun voar(){/*...*/}
    }
    //A classe Avestruz é um subtipo da classe Pássaro.
    class Avestruz : Passaro(){

        //Avestruz é um pássaro, mas não pode voar.
        override fun voar(){/*...*/}

    }
    
}
```



```kotlin
class ModeloCorreto {

    open class Passaro{/*...*/}
    open class PassarosVoadores : Passaro() {
        open fun voar(){/*...*/}
    }

    class Pato : PassarosVoadores(){
        override fun voar(){/*...*/}
    }
    
    class Avestruz : Passaro()
    
}
```

## Interface Segregation Principle 

> Princípio da Segregação de Interfaces — ***Muitas interfaces específicas são melhores do que uma interface única geral***.

![]()

```kotlin
class ModeloErrado {

    interface Aves{
        fun voar()
    }
    class Papagaio:Aves{
        override fun voar(){/*...*/}
    }
    //A classe Pinguim é uma ave que não voa.
    class Pinguim:Aves{
        override fun voar(){/*...*/}
    }
    
}
```



```kotlin
class ModeloCorreto {

    interface Aves{/*...*/}
    interface AvesQueVoam:Aves{
        fun voar()
    }
    class Papagaio:AvesQueVoam{
        override fun voar(){/*...*/}
    }
    
    class Pinguim:Aves{/*...*/}
    
}
```

## Dependency Inversion Principle

> Princípio da Inversão de Dependência — ***Dependa de abstrações e não de implementações***.

![]()

```kotlin
class ModeloErrado {

    class Interruptor{

        private val ventilador:Ventilador = Ventilador()

        fun acionar(){
            if (ventilador.ligado()) ventilador.ligar() else ventilador.desligar()
        }
    }
    class Ventilador{

        fun ligado():Boolean = true
        fun ligar(){}
        fun desligar(){}
    }

}
```

No exemplo, podemos perceber que além de quebrar outros princípios do SOLID, a classe concreta *Interruptor* depende de uma outra classe concreta *Ventilador*. O Interruptor deveria ser capaz de acionar qualquer dispositivo independente de ser um ventilador uma lâmpada ou até mesmo um carro.

```kotlin
class ModeloCorreto {

    interface Dispositivo {
        fun acionar()
        fun ligado(): Boolean
        fun ligar()
        fun desligar()
    }

    class Ventilador : Dispositivo {

        override fun ligado(): Boolean = true
        override fun ligar() = println("Ligado")
        override fun desligar() = println("Desligado")
        override fun acionar() = if (ligado()) ligar() else desligar()

    }
    class Lampada:Dispositivo{

        override fun ligado(): Boolean = false
        override fun ligar() = println("Ligado")
        override fun desligar() = println("Desligado")

        override fun acionar() = if (ligado()) ligar() else desligar()

    }
    class Interruptor(private val dispositivo:Dispositivo){

        fun adionarDispositivo(){
            dispositivo.acionar()
        }

    }

}
```

## Fontes

1. https://medium.com/desenvolvendo-com-paixao/o-que-%C3%A9-solid-o-guia-completo-para-voc%C3%AA-entender-os-5-princ%C3%ADpios-da-poo-2b937b3fc530
2. https://medium.com/thiago-aragao/solid-princ%C3%ADpios-da-programa%C3%A7%C3%A3o-orientada-a-objetos-ba7e31d8fb25
3. https://medium.com/backticks-tildes/the-s-o-l-i-d-principles-in-pictures-b34ce2f1e898
