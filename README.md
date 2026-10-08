**# Projeto Celular - POO**

Atividade realizada em classe no dia **\*20/08/26*\* na aula de Programação Orientada a Objetos, a qual será dada continuidade a cada aula até o fim do semestre. Portanto, esse Readme.md irá ser atualizado conforme a evolução do projeto, podendo haver alterações no seu contéudo, bem como remoção de antigas informações que não fazem mais sentido e adição de novas.

**## Sobre o projeto**

Este projeto foi desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos (POO), no qual o objeto escolhido foi um **\*celular*\**, representando o aparelho utilizado no mundo real para realizar diversas funções.

A classe `Celular` funciona como uma superclasse, concentrando características e comportamentos comuns aos diferentes tipos de celulares. A partir dela, foram criadas as classes filhas `Apple` e `Motorola`, que herdam de `Celular` por meio de `extends` e possuem características específicas.

**## Classes e atributos**

### `Celular`

A classe `Celular` é a superclasse do projeto e possui os seguintes atributos:

* `modelo`: representa o modelo do celular.
* `bateria`: representa o objeto `Bateria` associado ao celular.
* `volume`: representa o nível de volume do aparelho.

  * Inicia em 0

Os atributos são privados (`private`) para proteger o estado do objeto.

### `Apple`

A classe `Apple` é uma classe filha de `Celular` e possui o seguinte atributo exclusivo:

* `airdrop`: representa a disponibilidade do recurso AirDrop.

  * Definido como `true` na criação do objeto.

O modelo do aparelho é definido no momento da criação do objeto por meio do construtor da classe `Apple`.

### `Motorola`

A classe `Motorola` é uma classe filha de `Celular` e possui o seguinte atributo exclusivo:

* `botoesInterativos`: representa a utilização de botões interativos.

  * Definido como `true` na criação do objeto.

O modelo do aparelho é definido no momento da criação do objeto por meio do construtor da classe `Motorola`.

### `Bateria`

A classe `Bateria` possui o seguinte atributo:

* `porcentagem`: representa a porcentagem de bateria do aparelho.

  * Inicia em 0%

**## Herança e generalização**

Na aula de **\*24/09/26*\**, a classe `Celular` passou a ser utilizada como uma superclasse, enquanto `Apple` e `Motorola` passaram a ser suas subclasses.

A relação de herança é definida por meio da palavra-chave `extends`:

```java
public class Apple extends Celular {
```

```java
public class Motorola extends Celular {
```

Isso permite que `Apple` e `Motorola` herdem comportamentos e atributos da classe `Celular`, como `modelo`, `bateria`, `volume`, `aumentarVolume()`, `carregarBateria()` e os métodos relacionados ao modelo.

As classes filhas também possuem seus próprios atributos específicos:

* `Apple` possui `airdrop`.
* `Motorola` possui `botoesInterativos`.

Dessa forma, os elementos comuns ficam concentrados na classe mãe, enquanto as características específicas ficam nas classes filhas.

**## Construtores**

Na aula de **\*24/09/26*\**, o construtor da classe `Celular` passou a receber os dados necessários para inicializar o objeto:

```java
public Celular(String modelo, Bateria bateria) {
    this.modelo = modelo;
    this.bateria = bateria;
}
```

Nas classes filhas, o construtor utiliza `super()` para chamar o construtor da classe mãe e recebe os valores que serão utilizados na criação de cada objeto:

```java
public Apple(String modelo, Bateria bateria, boolean airdrop) {
    super(modelo, bateria);
    this.airdrop = airdrop;
}
```

```java
public Motorola(String modelo, Bateria bateria, boolean botoesInterativos) {
    super(modelo, bateria);
    this.botoesInterativos = botoesInterativos;
}
```

O `super()` é utilizado para executar o construtor da superclasse. Dessa forma, a classe filha consegue inicializar os atributos que pertencem à estrutura de `Celular`.

Além disso, os valores específicos de cada objeto são definidos no `Main.java`, no momento em que o objeto é criado:

```java
Apple apple = new Apple("iPhone 17 Pro Max", new Bateria(0), true);

Motorola motorola = new Motorola("Moto G", new Bateria(0), true);
```

Isso permite que o construtor seja reutilizado para criar diferentes objetos da mesma classe, sem precisar alterar a classe `Apple` ou `Motorola`.

**## Métodos**

### `setModelo()`

O método `setModelo(String modelo)` pertence à classe `Celular` e permite definir o modelo do aparelho.

```java
public void setModelo(String modelo) {
    this.modelo = modelo;
}
```

Como `modelo` é um atributo `private` da superclasse, as classes filhas não alteram o atributo diretamente. Elas utilizam os métodos disponibilizados pela classe mãe para trabalhar com essas informações.

### `getModelo()`

O método `getModelo()` pertence à classe `Celular` e retorna o modelo do aparelho.

```java
public String getModelo() {
    return modelo;
}
```

### `aumentarVolume()`

O método `aumentarVolume(int quantidade)` aumenta o volume do celular de acordo com a quantidade informada.

Regra de negócio:

* A quantidade deve ser maior que zero.
* O volume não pode ultrapassar 100.

Exemplo:

```java
celular.aumentarVolume(20);
```

### `carregarBateria()`

O método `carregarBateria(int quantidade)` solicita que o objeto `Bateria` associado realize o carregamento.

```java
public void carregarBateria(int quantidade) {
    bateria.carregar(quantidade);
}
```

A regra de negócio do carregamento é responsabilidade da classe `Bateria`, que verifica se a quantidade é maior que zero e se a porcentagem não ultrapassará 100%.

### `getBateria()`

O método `getBateria()` retorna a porcentagem da bateria por meio do objeto `Bateria` associado.

```java
public int getBateria() {
    return bateria.getPorcentagem();
}
```

### `getVolume()`

O método `getVolume()` retorna o nível atual do volume do celular.

```java
public int getVolume() {
    return volume;
}
```

### `isAirdrop()`

Na classe `Apple`, o método `isAirdrop()` retorna o estado do atributo `airdrop`.

```java
public boolean isAirdrop() {
    return airdrop;
}
```

O método `setAirdrop(boolean airdrop)` permite alterar esse estado.

### `isBotoesInterativos()`

Na classe `Motorola`, o método `isBotoesInterativos()` retorna o estado do atributo `botoesInterativos`.

```java
public boolean isBotoesInterativos() {
    return botoesInterativos;
}
```

O método `setBotoesInterativos(boolean botoesInterativos)` permite alterar esse estado.

### `getPorcentagem()`

O método `getPorcentagem()` pertence à classe `Bateria` e retorna sua porcentagem atual.

```java
public int getPorcentagem() {
    return porcentagem;
}
```

### `carregar()`

O método `carregar(int quantidade)` pertence à classe `Bateria` e é responsável por aumentar sua porcentagem.

Regra de negócio:

* A quantidade deve ser maior que zero.
* A porcentagem da bateria não pode ultrapassar 100%.

```java
public void carregar(int quantidade) {
    if (quantidade > 0 && porcentagem + quantidade <= 100) {
        porcentagem = porcentagem + quantidade;
    }
}
```

**## Associação entre objetos**

Na aula de **\*17/09/26*\**, foi criada uma nova classe chamada `Bateria` para realizar uma associação com a classe `Celular`.

O atributo `bateria` da classe `Celular` armazena um objeto da classe `Bateria`.

```java
private Bateria bateria;
```

Essa associação permite que o `Celular` utilize os comportamentos da `Bateria`, enquanto a própria classe `Bateria` fica responsável por controlar sua porcentagem e suas regras de negócio.

Com a evolução para herança na aula de 24/09/26, os objetos `Apple` e `Motorola` também utilizam essa associação por herdarem os atributos e comportamentos relacionados à bateria de `Celular`.

**## Testes**

O `Main.java` foi atualizado para testar as classes filhas `Apple` e `Motorola`, seus atributos específicos e também os comportamentos herdados de `Celular`.

Os testes realizados verificam:

* O modelo de cada aparelho.
* O funcionamento do `airdrop` da `Apple`.
* O funcionamento dos `botoesInterativos` da `Motorola`.
* O aumento de volume por meio do método herdado de `Celular`.
* O carregamento da bateria por meio dos métodos herdados de `Celular`.
* O funcionamento da associação com `Bateria`.

Os objetos são criados no `Main.java` informando os valores de seus atributos:

```java
Apple apple = new Apple("iPhone 17 Pro Max", new Bateria(0), true);

Motorola motorola = new Motorola("Moto G", new Bateria(0), true);
```

A saída obtida nos testes foi:

```text
APPLE
Modelo: iPhone 17 Pro Max
Airdrop: true
Volume: 20
Bateria: 80%
Som do iPhone

MOTOROLA
Modelo: Moto G
Botoes interativos: true
Volume: 30
Bateria: 70%
Som do Motorola
```

Os testes demonstram que as classes `Apple` e `Motorola` conseguem utilizar os comportamentos herdados de `Celular`, além de apresentarem suas próprias características.

**## Encapsulamento**

Os atributos das classes `Celular`, `Apple`, `Motorola` e `Bateria` são privados (`private`) para proteger o estado dos objetos.

O atributo `modelo`, por exemplo, pertence à classe `Celular` e não pode ser alterado diretamente pelas classes filhas. Para trabalhar com essa informação, são utilizados os métodos disponibilizados pela classe mãe, como `getModelo()` e `setModelo()`.

A bateria, por exemplo, não possui um `setPorcentagem()` público. Sua alteração ocorre por meio do método `carregar()`, que possui condições para impedir valores inválidos.

Dessa forma, cada objeto controla como seu estado pode ser alterado, mantendo suas próprias responsabilidades e regras de negócio.

**## Projeto Celular - Pergunta de Reflexão "Clean Code" - Aula 10/09/26**

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

**## Projeto Celular - Pergunta de reflexão "Associação entre objetos" - Aula 17/09/26**

***\*"No construtor da Viagem, nós exigimos o objeto inteiro (Passageiro solicitante). Se o nosso resumo só precisa imprimir o nome da pessoa, não seria mais fácil e mais leve pedir apenas a String do nome no construtor da Viagem (String nomeDoPassageiro) em vez do objeto todo?"*\***

***\*Pense nas regras de negócio: O que acontece na hora que a Viagem acaba e o sistema precisa descontar o saldo? Se a Viagem tiver apenas a String "Ana Silva", ela consegue mexer no dinheiro dela?*\***

Em resumo, não podemos apenar pedir a `String` do nome no construtor, pois uma `String` guarda apenas o dado e um objeto nos permite acessar os dados + comportamentos e atributos da pessoa. Por exemplo, se uma `Viagem` recebesse apenas a `String` `"Ana Silva"`, ela receberia o nome do passageiro, mas não teria acesso aos atributos do objeto `Passageiro` para realizar outras ações, como descontar diretamente do saldo da pessoa.

Sendo assim, neste projeto, o `Celular` passou a ter uma relação com o objeto `Bateria` e ao invés de apenas armazenar um número, a `Bateria` agora é responsável por controlar sua porcentagem e regra de comportamento. Contudo, utilizar o objeto associado permite que cada classe mantenha suas próprias responsabilidades e regras de negócio, deixando o código mais organizado.

**## Projeto Celular - Pergunta de reflexão "A Árvore Genealógica - Herança (Generalização)" - Aula 24/09/26**

***\*"No nosso código, a mãe `Veiculo` possui os atributos `placa` e `modelo` como `private`. Quando o `Carro` herda de `Veiculo`, ele recebe esses atributos, mas o código dentro de Carro NÃO consegue fazer `this.placa = "ABC"`. Ele é obrigado a usar o `super()` ou o `setPlaca()`.*\***

***\*Por que o Java não deixa a filha alterar as variáveis privadas da mãe diretamente? Qual o princípio das aulas passadas que isso está protegendo?*\***

O Java não permite que a classe filha altere diretamente os atributos private da classe mãe, porque esses atributos estão encapsulados e só podem ser acessados diretamente dentro da própria classe onde foram declarados. Assim, isso protege os dados de alterações indevidas e permite que a classe mãe controle como seus atributos serão modificados. Por isso, a classe filha precisa utilizar métodos como `setPlaca()` ou o construtor com `super()`, protegendo o encapsulamento, que mantém os atributos protegidos e controla o acesso a eles (princípio das aulas anteriores).

Neste projeto, isso se encaixa nos atributos da classe `Celular`, como `modelo` e `bateria`, que ficam protegidos pelo encapsulamento. As classes `Apple` e `Motorola`, mesmo herdando de `Celular`, não alteram esses atributos diretamente, utilizando métodos como `setModelo()` ou o construtor com `super()`. Assim, mantemos os dados protegidos e organizados dentro da estrutura de herança do projeto.

**## Projeto Celular - Pergunta de reflexão "Muitas Formas: Polimorfismo de Sobrescrita" - Aula 08/10/26**

***\*"No nosso loop `for (Veiculo veiculo : frota)`, a variável `veiculo` é do tipo genérico `Veiculo`. Se esquecêssemos de criar o método `calcularAutonomia()` lá na classe mãe `Veiculo`, nós conseguiríamos chamá-lo dentro do loop, mesmo sabendo que ele existe dentro do `Carro` e da `Moto`? Por que o contrato precisa existir na base da hierarquia?"*\***

A variável `veiculo` é do tipo `Veiculo`, então ela só consegue acessar os métodos que existem na classe `Veiculo`. Mesmo que `Carro` e `Moto` possuam o método `calcularAutonomia()`, não seria possível chamá-lo pelo `veiculo` se esse método não existisse na classe mãe.

O contrato precisa existir na classe base porque ele garante que todas as classes filhas terão esse comportamento. Assim, o loop pode trabalhar com qualquer objeto do tipo `Veiculo` e o polimorfismo permite que cada classe filha execute sua própria implementação do método.

No nosso projeto, isso acontece de forma semelhante com o método `tocarSom()`. O método foi criado na classe `Celular`, que é a classe mãe, e depois foi sobrescrito nas classes `Apple` e `Motorola`. Por isso, na nossa lista `List<Celular>`, podemos percorrer os objetos usando uma variável do tipo `Celular` e chamar `celular.tocarSom()`. Mesmo sendo do tipo `Celular`, cada objeto executa a sua própria versão do método: o `Apple` executa "Som do iPhone" e o `Motorola` executa "Som do Motorola".

**## Lista polimórfica**

Na aula de **\*08/10/26*\**, foi aplicada uma lista polimórfica utilizando a classe mãe `Celular` como tipo da lista.

A lista é criada da seguinte forma:

```java
List<Celular> celulares = new ArrayList<>();
```

Depois, os objetos das classes filhas são adicionados à lista:

```java
celulares.add(apple);
celulares.add(motorola);
```

Como `Apple` e `Motorola` herdam de `Celular`, os dois objetos podem ser armazenados em uma mesma lista do tipo `Celular`.

Para percorrer a lista, foi utilizado um `for`:

```java
for (Celular celular : celulares) {
    System.out.println("Modelo: " + celular.getModelo());
    celular.tocarSom();
    System.out.println("-------------------------");
}
```

O método `tocarSom()` existe na classe `Celular`, mas é sobrescrito nas classes filhas.

Na classe `Apple`:

```java
@Override
public void tocarSom() {
    System.out.println("Som do iPhone");
}
```

Na classe `Motorola`:

```java
@Override
public void tocarSom() {
    System.out.println("Som do Motorola");
}
```

Dessa forma, mesmo utilizando uma variável do tipo `Celular`, cada objeto executa sua própria implementação do método `tocarSom()`.

A saída da lista polimórfica foi:

```text
LISTA POLIMORFICA
Modelo: iPhone 17 Pro Max
Som do iPhone
-------------------------
Modelo: Moto G
Som do Motorola
-------------------------
```

Isso demonstra o polimorfismo de sobrescrita, pois o mesmo método `tocarSom()` possui comportamentos diferentes dependendo do objeto que está sendo utilizado.

**## Evolução do projeto**

### 20/08/26

* Criação da classe `Celular`.
* Definição dos atributos `marca`, `modelo`, `bateria` e `volume`.
* Utilização de atributos privados (`private`).
* Criação do método `aumentarVolume()`.
* Criação do método `carregarBateria()`.
* Implementação das regras para impedir valores inválidos.
* Criação do `Main.java` para testar o funcionamento do objeto.

### 10/09/26

* Criação do construtor da classe `Celular`.
* Definição de `marca` e `modelo` como atributos essenciais para a criação do objeto.
* Alteração do construtor para receber os atributos essenciais.
* Utilização de `this.setMarca(marca)` e `this.setModelo(modelo)` no construtor.
* Criação dos métodos `setMarca()` e `setModelo()`.
* Alteração do `Main.java` para utilizar o novo construtor.
* Aplicação dos conceitos de encapsulamento e Clean Code.
* Adição da reflexão sobre getters, setters e proteção contra falhas de lógica.

### 17/09/26

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

### 24/09/26

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

### 08/10/26

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
