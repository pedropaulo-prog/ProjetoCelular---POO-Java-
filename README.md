# Projeto Celular - POO

Atividade realizada em classe no dia **20/08/26** na aula de Programação Orientada a Objetos, a qual será dada continuidade a cada aula até o fim do semestre. Portanto, esse Readme.md irá ser atualizado conforme a evolução do projeto, podendo haver alterações no seu contéudo, bem como remoção de antigas informações que não fazem mais sentido e adição de novas.

## Sobre o projeto

O Projeto Celular foi desenvolvido durante as aulas de Programação Orientada a Objetos (POO), com o objetivo de aplicar conceitos como classes, objetos, atributos, métodos, encapsulamento, associação, herança, polimorfismo e classes abstratas. 

O projeto possui as classes `Celular`, `Apple`, `Motorola` e `Bateria`. A classe `Celular` representa a estrutura geral dos aparelhos, enquanto `Apple` e `Motorola` representam tipos específicos de celulares. A classe `Bateria` é associada aos celulares para controlar a porcentagem de carga.

## Classes e atributos

- **Celular:** classe abstrata que reúne os atributos e comportamentos comuns aos celulares.
- **Apple:** classe que herda de `Celular` e possui o atributo `airdrop`.
- **Motorola:** classe que herda de `Celular` e possui o atributo `botoesInterativos`.
- **Bateria:** classe responsável por armazenar e controlar a porcentagem da bateria.

Os atributos são privados (`private`), protegendo os dados e impedindo o acesso direto de outras classes.

## Herança e generalização

As classes `Apple` e `Motorola` utilizam `extends Celular` para herdar os atributos e métodos da classe principal.

A herança evita a repetição de código, pois os comportamentos comuns ficam concentrados na classe `Celular`, enquanto cada subclasse mantém suas características específicas.

## Construtores

Os construtores são utilizados para inicializar os objetos com os valores necessários.

As subclasses utilizam `super()` para chamar o construtor da classe `Celular`, permitindo inicializar os dados herdados e associar a bateria ao aparelho.

## Métodos e comportamentos

Os métodos representam as ações que os objetos podem executar. No projeto, existem métodos para controlar o volume, carregar a bateria e reproduzir o som do aparelho.

O método `carregar(int quantidade)` verifica se a quantidade informada é válida, impedindo valores não positivos e cargas que ultrapassem 100%.

## Associação entre objetos

A classe `Celular` possui um objeto da classe `Bateria`. Dessa forma, cada celular pode acessar e controlar sua bateria por meio da associação entre as duas classes.

Essa estrutura permite que a bateria seja representada como um objeto próprio, com atributos e comportamentos específicos.

## Encapsulamento

O encapsulamento protege os atributos das classes por meio do modificador `private`. Para consultar informações, são utilizados métodos públicos (`get`).

A alteração dos dados deve ocorrer por métodos apropriados, respeitando as regras definidas no código. Por exemplo, o método `carregar()` valida a quantidade antes de alterar a porcentagem da bateria.

## Testes e resultados

O programa testa os objetos `Apple` e `Motorola`, verificando suas características, volume, porcentagem da bateria, tipo de conector e reprodução de som.

Resultado obtido no terminal:

```text
APPLE
Modelo: iPhone 17 Pro Max
Airdrop: true
Conector: Lightning
Volume: 20
Bateria: 80%
Som do iPhone

MOTOROLA
Modelo: Moto G
Botoes interativos: true
Conector: USB-C
Volume: 30
Bateria: 70%
Som do Motorola

LISTA POLIMORFICA
Modelo: iPhone 17 Pro Max
Conector: Lightning
Som do iPhone
-------------------------
Modelo: Moto G
Conector: USB-C
Som do Motorola
```

## Lista polimórfica

O projeto utiliza uma lista do tipo `List<Celular>` para armazenar objetos das subclasses `Apple` e `Motorola`.

```java
List<Celular> celulares = new ArrayList<>();

celulares.add(apple);
celulares.add(motorola);

for (Celular celular : celulares) {
    System.out.println("Modelo: " + celular.getModelo());
    System.out.println("Conector: " + celular.tipoDeConector());
    celular.tocarSom();
    System.out.println("-------------------------");
}
```

Mesmo que a variável do loop seja do tipo `Celular`, cada objeto executa o comportamento correspondente à sua classe. Isso acontece por meio do polimorfismo e da sobrescrita (`@Override`) dos métodos.

## Classes abstratas e método abstrato

A classe `Celular` foi definida como abstrata utilizando `abstract`. Isso impede que ela seja instanciada diretamente, pois representa uma estrutura geral para os celulares.

Também foi criado o método abstrato `tipoDeConector()`, que obriga as subclasses concretas a implementarem seu próprio comportamento.

```java
public abstract class Celular {
    public abstract String tipoDeConector();
}
```

Na classe `Apple`, o método retorna `"Lightning"`, enquanto na classe `Motorola`, retorna `"USB-C"`.

Assim, as subclasses compartilham a estrutura geral de `Celular`, mas fornecem suas próprias implementações para o tipo de conector e para o método `tocarSom()`.

**## Perguntas de Reflexão**

**### Aulas 2 - "Métodos e Comportamentos" - 20/08/26**

**\*Reflita: Se nós podemos simplesmente fazer passageiro.saldo = passageiro.saldo + 100 diretamente no código principal, por que dá tanto trabalho criar um método específico chamado adicionarSaldo(valor) para fazer isso? Quais seriam os riscos para a nossa startup de mobilidade se deixássemos qualquer programador alterar o saldo diretamente?*\**

Se alterássemos o saldo diretamente no código principal, qualquer programador poderia modificar seu valor sem respeitar regras de negócio. Por exemplo, seria possível adicionar dinheiro indevidamente ou realizar alterações que não deveriam ser permitidas. Ao criar um método específico, como `adicionarSaldo(valor)`, podemos centralizar as regras de alteração e controlar melhor o que acontece com o saldo, evitando fraudes e falhas de lógica.

No Projeto Celular, aplicamos esse mesmo princípio ao encapsulamento. Os atributos são privados (`private`), impedindo o acesso direto a eles fora da própria classe. Além disso, métodos como `carregar()` verificam se a quantidade informada é positiva e se a bateria não ultrapassará 100%. Dessa forma, protegemos os dados dos objetos e garantimos que suas alterações respeitem as regras definidas no código.

"**### Aula 3 - "Protegendo o Sistema - Encapsulamento (Getters e Setters)" - 27/08/26**

**\*No nosso código, os atributos são private, mas os métodos getSaldo() e getNome() são public. Por que é seguro deixar o get público, mas perigoso deixar o atributo original público?*\**
**\*Pense bem: Qual a diferença entre dar a alguém uma CÓPIA de um documento seu, e entregar o documento ORIGINAL para a pessoa rasurar?*\**

Os métodos `get` são públicos porque permitem consultar as informações de um objeto sem dar acesso direto ao atributo original. É como entregar uma cópia de um documento: a pessoa pode ler as informações, mas não consegue alterar o documento original por meio dessa cópia. Se os atributos fossem públicos, qualquer parte do código poderia modificá-los diretamente, sem respeitar as regras definidas pela classe.

No nosso Projeto Celular, utilizamos atributos privados (`private`) e métodos públicos, como `getModelo()` e `getVolume()`, para permitir a consulta dessas informações com segurança. Além disso, a bateria possui o método `getPorcentagem()`, enquanto sua alteração é feita pelo método `carregar()`, que verifica se a quantidade informada é válida e impede que a carga ultrapasse 100%. Assim, protegemos os dados dos objetos e mantemos o controle sobre as alterações.

**### Aula 4 - "Construtores" - 10/09/26**

**\*Pensando no mundo real e no Clean Code: Por que é um erro gravíssimo clicar em "Gerar Getters e Setters para tudo" automaticamente na sua IDE? Como as nossas duas decisões acima protegem o sistema de fraudes e falhas de lógica?*\**

Pensando em um mundo real, apenas gerar "Getter" e "Setter" no código do sistema pode acarretar em um sério problema de informações não reais. Ou seja, nem toda informação do objeto deve ser alterada livremente. Se tivéssemos um setter público para a bateria, mesmo que o atributo fosse privado, uma pessoa poderia simplesmente adicionar 150% de bateria ao objeto, invalidando a lógica do sistema.

Por isso, é muito importante nos atentarmos para que, quando criarmos um atributo privado, não criemos automaticamente um setter público. Quando for necessário alterar um atributo, devemos criar métodos e condições que representem ações reais do objeto que possam ser validadas pelo sistema. Assim, protegemos o sistema contra fraudes e falhas de lógica.

Por exemplo:

```java
public void carregar(int quantidade) {
    if (quantidade > 0 && porcentagem + quantidade <= 100) {
        porcentagem = porcentagem + quantidade;
    }
}
```

Aqui podemos observar que o usuário não pode simplesmente definir qualquer valor para a bateria. Ele informa uma quantidade que deseja adicionar, e o sistema verifica se ela é maior que zero e se a bateria, após o carregamento, não ultrapassará 100%.

**### Aula 5 - "Associação entre objetos" - 17/09/26**

***\*"No construtor da Viagem, nós exigimos o objeto inteiro (Passageiro solicitante). Se o nosso resumo só precisa imprimir o nome da pessoa, não seria mais fácil e mais leve pedir apenas a String do nome no construtor da Viagem (String nomeDoPassageiro) em vez do objeto todo?"*\***

***\*Pense nas regras de negócio: O que acontece na hora que a Viagem acaba e o sistema precisa descontar o saldo? Se a Viagem tiver apenas a String "Ana Silva", ela consegue mexer no dinheiro dela?*\***

Em resumo, não podemos apenar pedir a `String` do nome no construtor, pois uma `String` guarda apenas o dado e um objeto nos permite acessar os dados + comportamentos e atributos da pessoa. Por exemplo, se uma `Viagem` recebesse apenas a `String` `"Ana Silva"`, ela receberia o nome do passageiro, mas não teria acesso aos atributos do objeto `Passageiro` para realizar outras ações, como descontar diretamente do saldo da pessoa.

Sendo assim, neste projeto, o `Celular` passou a ter uma relação com o objeto `Bateria` e ao invés de apenas armazenar um número, a `Bateria` agora é responsável por controlar sua porcentagem e regra de comportamento. Contudo, utilizar o objeto associado permite que cada classe mantenha suas próprias responsabilidades e regras de negócio, deixando o código mais organizado.

**### Aula 6 - "A Árvore Genealógica - Herança (Generalização)" - 24/09/26**

***\*"No nosso código, a mãe `Veiculo` possui os atributos `placa` e `modelo` como `private`. Quando o `Carro` herda de `Veiculo`, ele recebe esses atributos, mas o código dentro de Carro NÃO consegue fazer `this.placa = "ABC"`. Ele é obrigado a usar o `super()` ou o `setPlaca()`.*\***

***\*Por que o Java não deixa a filha alterar as variáveis privadas da mãe diretamente? Qual o princípio das aulas passadas que isso está protegendo?*\***

O Java não permite que a classe filha altere diretamente os atributos private da classe mãe, porque esses atributos estão encapsulados e só podem ser acessados diretamente dentro da própria classe onde foram declarados. Assim, isso protege os dados de alterações indevidas e permite que a classe mãe controle como seus atributos serão modificados. Por isso, a classe filha precisa utilizar métodos como `setPlaca()` ou o construtor com `super()`, protegendo o encapsulamento, que mantém os atributos protegidos e controla o acesso a eles (princípio das aulas anteriores).

Neste projeto, isso se encaixa nos atributos da classe `Celular`, como `modelo` e `bateria`, que ficam protegidos pelo encapsulamento. As classes `Apple` e `Motorola`, mesmo herdando de `Celular`, não alteram esses atributos diretamente, utilizando métodos como `setModelo()` ou o construtor com `super()`. Assim, mantemos os dados protegidos e organizados dentro da estrutura de herança do projeto.

**### Aula 7 - "Muitas Formas: Polimorfismo de Sobrescrita" - 08/10/26**

***\*"No nosso loop `for (Veiculo veiculo : frota)`, a variável `veiculo` é do tipo genérico `Veiculo`. Se esquecêssemos de criar o método `calcularAutonomia()` lá na classe mãe `Veiculo`, nós conseguiríamos chamá-lo dentro do loop, mesmo sabendo que ele existe dentro do `Carro` e da `Moto`? Por que o contrato precisa existir na base da hierarquia?"*\***

A variável `veiculo` é do tipo `Veiculo`, então ela só consegue acessar os métodos que existem na classe `Veiculo`. Mesmo que `Carro` e `Moto` possuam o método `calcularAutonomia()`, não seria possível chamá-lo pelo `veiculo` se esse método não existisse na classe mãe. O contrato precisa existir na classe base porque ele garante que todas as classes filhas terão esse comportamento. Assim, o loop pode trabalhar com qualquer objeto do tipo `Veiculo` e o polimorfismo permite que cada classe filha execute sua própria implementação do método.

Nesse projeto, isso acontece de forma semelhante com o método `tocarSom()`. O método foi criado na classe `Celular`, que é a classe mãe, e depois foi sobrescrito nas classes `Apple` e `Motorola`. Por isso, na nossa lista `List<Celular>`, podemos percorrer os objetos usando uma variável do tipo `Celular` e chamar `celular.tocarSom()`. Mesmo sendo do tipo `Celular`, cada objeto executa a sua própria versão do método: o `Apple` executa "Som do iPhone" e o `Motorola` executa "Som do Motorola".

**### Aula 8 - "O Molde Invisível - Classes Abstratas" - 15/10/26**

**\*"Pense no mundo real: Faz sentido existir um objeto que é APENAS 'Veículo' sem ser um tipo específico? Você já entrou em uma concessionária e comprou "um veículo" genérico, sem ser carro, moto, caminhão ou nada disso?*\**

**\*Por que, então, no código, precisamos EXPLICITAMENTE dizer ao Java que Veiculo é abstract? Por que ele não deduz isso sozinho?*\**

**\*Pense: Se esquecermos de colocar abstract, qual o risco que corremos? Alguém pode criar new Veiculo() e quebrar a lógica do nosso sistema?"*\**

No mundo real, não faz muito sentido comprar apenas um "veículo" genérico, pois normalmente compramos um tipo específico, como um carro ou uma moto. No nosso projeto, acontece algo semelhante: não criamos um celular genérico, mas sim objetos específicos das classes `Apple` e `Motorola`. Por isso, precisamos declarar `Celular` como `abstract`, indicando ao Java que essa classe serve como um modelo para as classes filhas, e não para criar objetos diretamente. O Java não deduz isso sozinho porque precisamos informar explicitamente essa intenção no código.

Se esquecermos de colocar `abstract`, alguém poderá criar um objeto diretamente com `new Celular()`, mesmo que a intenção do projeto seja trabalhar apenas com tipos específicos de celulares. Isso permitiria criar um objeto genérico e poderia comprometer a lógica que queremos estabelecer. Ao tornar a classe abstrata, impedimos essa criação direta e garantimos que os objetos sejam instanciados por meio de classes concretas, como `Apple` e `Motorola`.

**## Evolução do projeto**

### 20/08/26 - Aula 2

* Criação da classe `Celular`.
* Definição dos atributos `marca`, `modelo`, `bateria` e `volume`.
* Utilização de atributos privados (`private`).
* Criação do método `aumentarVolume()`.
* Criação do método `carregarBateria()`.
* Implementação das regras para impedir valores inválidos.
* Criação do `Main.java` para testar o funcionamento do objeto.

### 27/08/26 - Aula 3

* Aplicação do conceito de encapsulamento.
* Utilização de atributos privados (`private`) para proteger os dados dos objetos.
* Criação e utilização de métodos getters e setters para controlar o acesso aos atributos.
* Aplicação de regras para controlar alterações nos dados, evitando valores inválidos.

### 10/09/26 - Aula 4

* Criação do construtor da classe `Celular`.
* Definição de `marca` e `modelo` como atributos essenciais para a criação do objeto.
* Alteração do construtor para receber os atributos essenciais.
* Utilização de `this.setMarca(marca)` e `this.setModelo(modelo)` no construtor.
* Criação dos métodos `setMarca()` e `setModelo()`.
* Alteração do `Main.java` para utilizar o novo construtor.
* Aplicação dos conceitos de encapsulamento e Clean Code.
* Adição da reflexão sobre getters, setters e proteção contra falhas de lógica.

### 17/09/26 - Aula 5

* Criação da nova classe `Bateria`.
* Criação do atributo `porcentagem` na classe `Bateria`.
* Criação do construtor da classe `Bateria`.
* Criação do método `getPorcentagem()`.
* Criação do método `carregar()`.
* Associação entre as classes `Celular` e `Bateria`.
* Alteração do atributo `bateria` da classe `Celular` para utilizar um objeto `Bateria`.
* Atualização do construtor de `Celular` para receber um objeto `Bateria`.
* Atualização do método `carregarBateria()` para utilizar o objeto `Bateria` associado.
* Criação de um teste no `Main.java` para imprimir um dado do objeto associado.
* Adição da reflexão sobre associação entre objetos e responsabilidades das classes.

### 24/09/26 - Aula 6

* Transformação da classe `Celular` em superclasse.
* Criação da classe filha `Apple`.
* Criação da classe filha `Motorola`.
* Utilização de `extends` para estabelecer a herança entre `Celular`, `Apple` e `Motorola`.
* Definição de `airdrop` como atributo exclusivo da classe `Apple`.
* Definição de `botoesInterativos` como atributo exclusivo da classe `Motorola`.
* Utilização de `super()` nos construtores das classes filhas para chamar o construtor de `Celular`.
* Transferência do atributo `modelo` para a superclasse `Celular`.
* Utilização de métodos da classe mãe pelas classes filhas para trabalhar com os atributos herdados.
* Criação e utilização de getters e setters para os atributos específicos de `Apple` e `Motorola`.
* Atualização do `Main.java` para testar as classes filhas e os comportamentos herdados de `Celular`.
* Aplicação dos conceitos de herança, generalização e encapsulamento.
* Adição da reflexão sobre herança e proteção dos atributos privados da classe mãe.

### 08/10/26 - Aula 7

* Atualização dos construtores de `Apple` e `Motorola` para receber os valores dos objetos no momento da criação.
* Utilização de `super(modelo, bateria)` nos construtores das classes filhas.
* Definição dos valores dos objetos no `Main.java`.
* Criação de dois objetos `Celular` por meio das classes filhas `Apple` e `Motorola`.
* Sobrescrita do método `tocarSom()` na classe `Apple`.
* Sobrescrita do método `tocarSom()` na classe `Motorola`.
* Aplicação do polimorfismo de sobrescrita.
* Criação de uma lista polimórfica utilizando `List<Celular>`.
* Adição dos objetos `Apple` e `Motorola` na lista.
* Utilização de um `for` para percorrer a lista utilizando o tipo `Celular`.
* Adição da reflexão sobre polimorfismo e a necessidade do método na classe mãe.
* Teste final da lista polimórfica com os objetos `Apple` e `Motorola`.
