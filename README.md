# SOLID-Kotlin
Projeto de estudo baseado nos principais conceitos sobre o SOLID.

![](src/imagens/SOLID.png)

## O que é o SOLID?

> O SOLID são cinco princípios da programação orientada a objetos que facilitam no desenvolvimento de softwares, tornando-os fáceis de manter e estender. Esses princípios podem ser aplicados a qualquer linguagem de POO.

## Por que é tão importante aprender esses conceitos?

É importante porque esses princípios são a base para vários Padrões e Projetos e tornam softwares mais evolutivos, de fácil manutenção e facilita mudanças necessárias após a finalização do projeto, não impactando em outras áreas do programa. De fato, podemos afirmar que um software que não segue tais princípios é um software mal escrito e de má qualidade. 

## Os princípios do SOLID

1. S **— Single Responsibility Principle** (Princípio da Responsabilidade Única)
2. O **— Open-Closed Principle** (Princípio Aberto-Fechado)
3. L **— Liskov Substitution Principle** (Princípio da Substituição de Liskov)
4. I **— Interface Segregation Principle** (Princípio da Segregação da Interface)
5. D **— Dependency Inversion Principle** (Princípio da Inversão da Dependência)

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

A classe `Robot ` viola o Single Responsiblity Principle (SRP) porque realiza 4 tipos distintos de tarefas, ou seja, ela executa ações diferentes em uma mesma classe. Lembre-se, o Princípio da Responsabilidade Única preza que *uma classe deve ter um, e somente um, motivo para mudar*.  

**A violação do Single Responsibility Principle pode gerar alguns problemas, sendo eles:**

- **Classe não coesa:** uma classe não deve assumir responsabilidades que não são suas. Classes não coesas têm uma grande chance de terem defeitos. Toda classe que é não coesa ***não para de crescer nunca***.
- **Alto acoplamento:** mais responsabilidades geram um maior nível de dependências, deixando o sistema engessado e frágil para alterações.
- **Dificuldades na implementação de testes automatizados:**  é difícil de *“mockar”* *esse tipo de classe.
- **Dificuldades para reaproveitar o código.**

> **Mock ou Mockar :** em desenvolvimento de software são objetos que simulam o comportamento de objetos reais de forma controlada. São normalmente criados para testar o comportamento de outros objetos. 

> **Coesão:** uma classe coesa é aquela que possui uma única responsabilidade. Além disso, elas são vitais em um sistema orientado a objetos. 

> **Acoplamento:** é a união ou ligação entre dois ou mais corpos, formando um único conjunto. Esse corpo pode ser representado por classes, entidades, métodos, componentes, tabelas etc. Quando falamos, por exemplo, de relacionamento entre Classes, Tabelas, Domínios, Sub-Sistemas, Casos de Uso etc. estamos falando de acoplamento. Podemos afirmar que no contexto de um software *qualquer relacionamento gera acoplamento*.
>
> - **Baixo Acoplamento:** quando um sistema possui entre seus componentes uma relação de **interdependência fraca**, significa que a **dependência entre seus componentes** é baixa, ou seja, estão acoplados, **mas fracamente acoplados**. 
> - **Alto Acoplamento**: quando um sistema possui entre seus componentes uma relação de **interdependência forte**, significa que a **dependência entre seus componentes** é alta, ou seja, estão acoplados, **mas fortemente acoplados**.
>
>  

Aplicando o Single Responsiblity Principle (SRP) na classe `Robot `, podemos refatorar o código da seguinte forma:

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

Note que no exemplo acima que agora temos 4 classes, cada uma cuidando da sua responsabilidade.

> Esse princípio é um dos mais importantes, ele acaba sendo a base para outros princípios e padrões, além disso ela aborda temas como acoplamento e coesão, características que todo código orientado a objetos deveria ter.

**O uso do Princípio da Responsabilidade Única gera os seguintes benefícios, sendo eles:**

- **Coesão das classes:** classes coesas tendem a ter menos código, são mais simples de serem mantidas, são menos suscetíveis a problemas, o seu reuso é mais fácil e a chance de propagarem problemas para outras classes é menor. 
- **Ela também pode ser aplicada para métodos e funções:** tudo que é responsável por executar uma ação, deve ser responsável por apenas aquilo que se propõe a fazer. 
- **Facilidade de manutenção e evolução do código**
- **Código limpo e de fácil entendimento**
- **Facilidade para desenvolvimento de testes**
- **Redução do acoplamento**
- **Complexidade reduzida**

> Não ache que você conseguirá escrever classes coesas o tempo todo, e de primeira. Escrever código de qualidade é sempre incremental; você modela, observa seu modelo, aprende com ele e o melhora.

Aplicando esse princípio, automaticamente você estará escrevendo um código mais limpo e de fácil manutenção.

## Open-Closed Principle 

> Princípio Aberto-Fechado — ***Você deve ser capaz de estender um comportamento de uma classe sem a necessidade de modificá-lo***.

![](src/imagens/OCP.png)

Esse princípio diz que *você deve ser capaz de estender um comportamento de uma classe sem a necessidade de modificá-lo*, ou seja, quando novos comportamentos e recursos precisam ser adicionados no software, devemos estender e não alterar o código fonte original.

**Veja um exemplo:**

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

A classe `Work `precisa verificar a classe `Robot ` para aplicar qual tipo de trabalho o robô faz. Supondo que o robô faça mais do que só cortar e pintar, obviamente seria necessário modificar essa classe. Lembre-se, o princípio aberto-fechado preza que *você deve ser capaz de estender um comportamento de uma classe sem a necessidade de modificá-lo*.

**A violação do Open-Closed Principle pode gerar alguns problemas, sendo eles:**

- **Alteração de classe:** quando alterarmos uma classe já existente para adicionar um novo comportamento, corremos um sério risco de introduzir bugs em algo que já estava funcionando.

Aplicando o Open-Closed Principle (OCP) na classe `ModeloCorreto`, podemos refatorar o código da seguinte forma:

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

A classe `Robot` não precisa saber quais são os tipos de trabalho do robô. Ela será capaz de executar diretamente as ações dos tipos de trabalho do robô (que é cortar e pintar, respectivamente) — *desde que ele implemente a interface* `Work` *—* sem qualquer necessidade de alteração do seu código fonte. Dessa forma, acabamos de implementar o Open-Closed Principle em nosso código.

**O uso do Princípio Aberto-Fechado gera os seguintes benefícios, sendo eles:**

- **Extensibilidade:** quando termos uma nova funcionalidade ou comportamento, não precisaremos alterar a classe já existente, e sim estendê-la. Com isso mantemos o código original confiável e intacto, e criamos um código com design duradouro, de qualidade e manutenibilidade altas.
- **Classes altamente testáveis:** a partir do momento em que a classe deixa clara todas as suas dependências, e possibilita a troca delas, criamos classes facilmente extensíveis.
- **Maior uso de abstrações:** quando usamos abstração no nosso código, ela permite que toda a mágica aconteça. Se temos abstrações bem definidas, conseguimos de forma fácil estender os métodos da nossa aplicação. O conceito do Open-Closed Principle indica principalmente o uso da herança para praticarmos a extensão dos métodos.

> **Abstração:** trata-se da capacidade de extrair dos personagens ou dos itens presentes no contexto, suas principais características, criando, dessa forma, objetos. Por exemplo: o que um papagaio e um cachorro têm em comum? Todos eles são animais. Sendo assim, a classe abstrata é Animal.

## Liskov Substitution Principle

> Princípio da Substituição de Liskov — ***As classes derivadas devem ser substituíveis por suas classes bases***.

![](src/imagens/LSP.png)

O *Liskov Substitution Principle* tem como objetivo nos alertar quanto a utilização da herança, que é um poderoso mecanismo e deve ser utilizado com extrema parcimônia.

Esse princípio foi introduzido por **Barbara Liskov** em sua conferência “Data abstraction” em 1987. A definição formal de Liskov diz que:

> Se para cada objeto o1 do tipo S há um objeto o2 do tipo T de forma que, para todos os programas P definidos em termos de T, o comportamento de P é inalterado quando o1 é substituído por o2 então S é um subtipo de T

Um exemplo mais simples e de fácil compreensão dessa definição. Seria:

> se S é um subtipo de T, então os objetos do tipo T, em um programa, podem ser substituídos pelos objetos de tipo S sem que seja necessário alterar as propriedades deste programa.

Podemos entender esse princípio da seguinte forma: ***As classes derivadas devem ser substituíveis por suas classes bases***.

**Veja um exemplo:**

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

Esse exemplo nos mostra a maneira errada de aplicar o princípio do *Liskov Substitution Principle* e o conceito de herança. A classe derivada `RobotEden` herda o método da classe base  `RobotSam`, mais ele não foi criado para servir café. Nesse caso, não deve ser aplicado o conceito de herança e isso viola o Princípio da Substituição de Liskov. Lembre-se, o Princípio da Substituição de Liskov preza que: *As classes derivadas devem ser substituíveis por suas classes bases*.  

> **Herança:** é um mecanismo que permite que características comuns a diversas classes sejam fatoradas em uma classe base, ou superclasse. Esse importante conceito possibilita que as classes compartilhem seus atributos, métodos e outros membros da classe entre si. Para a ligação entre as classes, a herança adota um relacionamento esquematizado hierarquicamente. Na Herança temos dois tipos principais de classe:
>
> - **Classe Base**: a classe que concede as características a uma outra classe.
> - **Classe Derivada**: a classe que herda as características da classe base.

Aplicando o Liskov Substitution Principle (LSP) na classe `ModeloCorreto`, podemos refatorar o código da seguinte forma:

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

**O uso do Princípio da Substituição de Liskov gera os seguintes benefícios, sendo eles:**

- **Uso correto de Herança:** quando respeitamos esse princípio conseguimos ter estruturas melhores e evitamos erros inesperados no nosso código.
- **Uso correto de Polimorfismo:** seguir esse princípio nos permite usar o polimorfismo com mais confiança. Consequentemente, isso torna o código mais fléxivel. 

> **Polimorfismo:** é o princípio pelo qual duas ou mais classes derivadas da mesma superclasse, ou classe base,  podem invocar métodos que têm a mesma assinatura, mas comportamentos distintos.

- ## Interface Segregation Principle 

> Princípio da Segregação de Interfaces — ***Muitas interfaces específicas são melhores do que uma interface única geral***.

![](src/imagens/ISP.png)

Esse princípio basicamente diz que é melhor criar *interfaces mais específicas ao invés de termos uma única interface genérica*.

**Veja um exemplo:**

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
    
    class RobotNotAntennas:Exercises{

        override fun spinAround() {/*..*/}
        override fun rotateArms() {/*..*/}
        //Isso não está certo!!!
        override fun wiggleAntennas() = println("Oops! But I don´t have antennas")


    }

}
```

Percebam que ao criar a interface `Exercises`, atribuímos comportamentos genéricos e isso acabou forçando a classe `RobotNotAntennas` a implementar o método `wiggleAntennas()`do qual ela não deveria ter, pois um robô que não possui antenas não pode mexer as antenas! Dessa forma, estamos violando o *Interface Segregation Principle* — E o *Liskov Substitution Principle* também!

**A violação do Interface Segregation Principle pode gerar um grande problema que é:**

- **Interface não coesa:** uma interface que não é coesa tende a ser mais génerica, assim como mostra o exemplo acima. Interfaces não coesas têm baixo reuso, e quando o desenvolvedor não tem a experiência necessária para perceber e resolver o problema, ele acaba por complicar ainda mais o projeto de classes.

Aplicando o Interface Segregation Principle (ISP) na classe `ModeloCorreto`, podemos refatorar o código da seguinte forma:

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

Note que no exemplo acima, a classe `RobotNotAntennas` agora possui as ações, ou métodos,  mais condizentes com as características da classe dele.

**O uso do Princípio da Segregação de Interfaces gera os seguintes benefícios, sendo eles:**

- **Interfaces coesas:** interfaces coesas são aquelas cujos comportamentos são simples e bem definidos. Ela também possue apenas uma única responsabilidade (elas seguem o Princípio da Responsabilidade Única). Suas implementações não precisam fazer “gambiarras” para se adaptarem. 
- **Maior reuso.**
- **Mais estáveis.**
- **Facilidade de manutenção e eficiência no código.**

## Dependency Inversion Principle

> Princípio da Inversão de Dependência — ***Dependa de abstrações e não de implementações***.

![](src/imagens/DIP.png)

O *Dependency Inversion Principle* é a base para termos um projeto com um excelente design orientado a objetos, focado no domínio e com um arquitetura flexível.

De uma forma objetiva o princípio nos faz entender que sempre devemos depender de abstrações e não das implementações, afinal de contas, as abstrações mudam menos e facilitam a mudança de comportamento e as evoluções do código.  Nesse princípio, você está invertendo a maneira de você depender das coisas, ao invés de você depender da implementação agora você passa a depender de abstrações.

De acordo com Uncle Bob, esse princípio pode ser definido da seguinte forma:

1. Módulos de alto nível ***não devem depender de módulos de baixo nível***. Ambos devem ***depender de abstrações***.
2. Abstrações ***não devem depender de detalhes***. Detalhes devem ***depender de abstrações***.

> - **Módulo:** é um artefato de programação que pode ser desenvolvido e compilado separadamente de outras partes do programa. São ficheiros com código que permitem aumentar as capacidades das linguagens de programação.
> - **Módulo de alto nível:** é um módulo que está mais próximo do domínio/negócio de um sistema.
> - **Módulo de baixo nível:** é um módulo que está mais próximo da infraestrutura de um sistema

Isso é o que nós chamamos de Princípio da Inversão de Dependência. Não confunda isso com Injeção de Dependência.  O nome é parecido.

A **Inversão de Dependência** é um *princípio (Conceito)* e a **Injeção de Dependência** é um *padrão de projeto (Design Pattern)*.

> **Injeção de Dependência:** é a ideia de você ter os parâmetros no construtor, e alguém, geralmente um framework, automaticamente injetar essas dependências pra você. Ele é usado para evitar o alto nível de acoplamento de código dentro de uma aplicação.

**Veja um exemplo:**

```kotlin
class ModeloErrado {

  class Robot{

        private val cutterArm:CutterArm = CutterArm()

        fun cutPizza() = cutterArm.cut()

    }

    class CutterArm{

        fun cut() = println("I cut pizza with my pizza cutter arm")

    }

}
```

No exemplo acima, podemos perceber que a classe `Robot` depende de uma outra classe — a classe  `CutterArm` . A classe  `Robot` deveria ser capaz de usar qualquer ferramenta independente de ser um braço cortador ou até mesmo um braço de faça.

**A violação do Dependency Inversion Principle Principle pode gerar alguns problemas, sendo eles:**

- **Alto acoplamento**: a partir do momento em que uma classe possui muitas dependências, ***todas elas podem propagar problemas para a classe principal***. A classe, quando possui muitas dependências, ***torna-se muito frágil, fácil de quebrar***.
- **Dificuldade de reuso:** o reuso dessas classes também fica cada vez mais difícil, afinal, se quisermos reutilizar uma determinada classe em outro lugar, ***precisaremos levar junto todas suas dependências***. Lembre-se também que as dependências de uma classe podem ter suas próprias dependências, gerando uma grande árvore de classes que devem ser levadas junto.

Aplicando o Dependency Inversion Principle (DIP) na classe `ModeloCorreto `, podemos refatorar o código da seguinte forma:

```kotlin
class ModeloCorreto {

 interface Tool{
        fun cutterArm()
        //Example
        //fun knifeArm()
    }

    class Robot(private val tool:Tool){

        fun print() = println("I cut with any tool given to me")
        fun cutPizza() = tool.cutterArm()
        //Example
        //fun cutPizza() = tool.knifeArm()

    }

}
```
Note que no exemplo acima, a classe `Robot` não tem a mínima ideia de qual tipo de ferramenta ele irá utilizar. 

> Como vimos no exemplo acima, sempre que uma classe for depender de outra, ela deve ***depender sempre de outro módulo mais estável do que ela mesma***. 

**O uso do Princípio da Inversão de Dependência gera os seguintes benefícios, sendo eles:**

- **Uso de construtor com interface coesa:** interface coesa é aquela cujo comportamento é simples e bem definido. Ela também possue apenas uma única responsabilidade (ela respeita o Princípio da Responsabilidade Única). Suas implementações não precisam fazer “gambiarras” para se adaptarem. Nesse contexto, você pode utilizar a **Injeção de Dependência**.
- **Reusabilidade:** quando aplicamos a interface coesa no construtor da classe, isso favorece a reusabilidade do código e como *“bônus”* também respeitamos o **Princípio da Responsabilidade Única** e o **Princípio Aberto-Fechado**.
- **Mais estáveis.**
- **Facilidade de manutenção e eficiência no código.**

## Diagramas de Classe

- **Single Responsibility Principle**

  | ![](src/imagens/uml/SRP-Robot1.png) | **Errado**🚫 |
  | :---------------------------------: | :---------: |
  | ![](src/imagens/uml/SRP-Robot2.png) | **Certo**✅  |

- **Open-Closed Principle**

  | ![](src/imagens/uml/OCP-Robot1.png) | **Errado**🚫 |
  | :---------------------------------: | :---------: |
  | ![](src/imagens/uml/OCP-Robot2.png) | **Certo**✅  |

- **Liskov Substitution Principle**

  | ![](src/imagens/uml/LSP-Robot1.png) | **Errado**🚫 |
  | :---------------------------------: | :---------: |
  | ![](src/imagens/uml/LSP-Robot2.png) | **Certo**✅  |

- **Interface Segregation Principle**

  | ![](src/imagens/uml/ISP-Robot1.png) | **Errado**🚫 |
  | :---------------------------------: | :---------: |
  | ![](src/imagens/uml/ISP-Robot2.png) | **Certo**✅  |

- **Dependency Inversion Principle**

  | ![](src/imagens/uml/DIP-Robot1.png) | **Errado**🚫 |
  | :---------------------------------: | :---------: |
  | ![](src/imagens/uml/DIP-Robot2.png) | **Certo**✅  |

   



## Fontes

1. https://medium.com/desenvolvendo-com-paixao/o-que-%C3%A9-solid-o-guia-completo-para-voc%C3%AA-entender-os-5-princ%C3%ADpios-da-poo-2b937b3fc530
2. https://medium.com/thiago-aragao/solid-princ%C3%ADpios-da-programa%C3%A7%C3%A3o-orientada-a-objetos-ba7e31d8fb25
3. https://medium.com/backticks-tildes/the-s-o-l-i-d-principles-in-pictures-b34ce2f1e898
