# Projeto Celular - POO
Atividade realizada em classe no dia ********20/08/26****** na aula de Programação Orientada a Objetos, a qual será dada continuidade a cada aula até o fim do semestre. Portanto, esse Readme.md irá ser atualizado conforme a evolução do projeto, podendo haver alterações no seu contéudo, bem como remoção de antigas informações que não fazem mais sentido e adição de novas.

## Sobre o projeto
Este projeto foi desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos (POO), no qual o objeto escolhido inicialmente foi um **celular**, representando o aparelho utilizado no mundo real para realizar diversas funções.

Ao longo das aulas, o projeto evoluiu com a aplicação de conceitos como encapsulamento, construtores, associação entre objetos e herança (generalização). Atualmente, a classe `Celular` representa a classe principal do projeto, sendo utilizada como superclasse para diferentes tipos de celulares, como `Apple` e `Motorola`.

A classe `Celular` possui características como modelo, bateria e volume, além de comportamentos que permitem alterar seu estado. As classes `Apple` e `Motorola` herdam esses comportamentos e possuem características específicas de cada fabricante.

## Classes
Atualmente, o projeto possui as seguintes classes:

* `Celular`: superclasse que representa as características e comportamentos comuns aos celulares.
* `Apple`: classe filha de `Celular`, representando um celular da Apple.
* `Motorola`: classe filha de `Celular`, representando um celular da Motorola.
* `Bateria`: classe responsável por representar a bateria e controlar sua porcentagem.
* `Main`: classe responsável por criar os objetos e realizar os testes do projeto.

## Atributos
A classe `Celular` possui os seguintes atributos:

* `modelo`: representa o modelo do celular.

* `bateria`: representa o objeto `Bateria` associado ao celular.

* `volume`: representa o nível de volume do aparelho.

  * Inicia em 0.

Os atributos são privados (`private`) para proteger o estado do objeto.

A classe `Bateria` possui o seguinte atributo:

* `porcentagem`: representa a porcentagem de bateria do aparelho.

A classe `Apple` possui o seguinte atributo:

* `airdrop`: representa se o recurso AirDrop está disponível no aparelho.

  * Inicia como `true`.

A classe `Motorola` possui o seguinte atributo:

* `botoesInterativos`: representa se o aparelho possui botões interativos.

  * Inicia como `true`.

## Construtores
Na aula de **10/09/26**, foi criado um construtor para a classe `Celular`, definindo os atributos essenciais para o nascimento do objeto. Posteriormente, na aula de **17/09/26**, com a associação entre `Celular` e `Bateria`, o construtor passou a receber também um objeto `Bateria`.

Atualmente, o construtor da classe `Celular` recebe `modelo` e um objeto `Bateria`:

```java
public Celular(String modelo, Bateria bateria) {
    this.modelo = modelo;
    this.bateria = bateria;
}
```

Na aula de ********24/09/26******, foram criadas as classes `Apple` e `Motorola`, que herdam de `Celular`.

A classe `Apple` utiliza `super()` para chamar o construtor da classe mãe e definir o modelo e a bateria:

```java
public Apple() {
    super("iPhone 17 Pro Max", new Bateria(0));
    this.airdrop = true;
}
```

A classe `Motorola` também utiliza `super()` para chamar o construtor da classe `Celular`:

```java
public Motorola() {
    super("Moto G", new Bateria(0));
    this.botoesInterativos = true;
}
```

Dessa forma, as classes filhas aproveitam a estrutura já existente na classe `Celular`, enquanto adicionam suas próprias características.

## Métodos

### getModelo()
O método `getModelo()` retorna o modelo do celular.

```java
public String getModelo() {
    return modelo;
}
```

### setModelo()
O método `setModelo(String modelo)` permite alterar o modelo do celular.

```java
public void setModelo(String modelo) {
    this.modelo = modelo;
}
```

**### aumentarVolume()**

O método `aumentarVolume(int quantidade)` aumenta o volume do celular de acordo com a quantidade informada.

Regra de negócio:

* A quantidade deve ser maior que zero.
* O volume não pode ultrapassar 100.

```java
public void aumentarVolume(int quantidade) {

    if (quantidade > 0 && volume + quantidade <= 100) {
        volume = volume + quantidade;
    }

}
```

### getVolume()
O método `getVolume()` retorna o volume atual do celular.

```java
public int getVolume() {
    return volume;
}
```

### carregarBateria()
O método `carregarBateria(int quantidade)` solicita que o objeto `Bateria` associado realize o carregamento.

```java
public void carregarBateria(int quantidade) {
    bateria.carregar(quantidade);
}
```

A regra de negócio do carregamento permanece sob responsabilidade da classe `Bateria`, que verifica se a quantidade é maior que zero e se a porcentagem não ultrapassará 100%.

### getBateria()
O método `getBateria()` retorna a porcentagem da bateria por meio do objeto `Bateria` associado.

```java
public int getBateria() {
    return bateria.getPorcentagem();
}
```

### getPorcentagem()
O método `getPorcentagem()` pertence à classe `Bateria` e retorna sua porcentagem atual.

```java
public int getPorcentagem() {
    return porcentagem;
}
```

### carregar()
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

### isAirdrop()
O método `isAirdrop()` pertence à classe `Apple` e retorna se o recurso AirDrop está disponível.

```java
public boolean isAirdrop() {
    return airdrop;
}
```

### setAirdrop()
O método `setAirdrop(boolean airdrop)` permite alterar o valor do atributo `airdrop`.

```java
public void setAirdrop(boolean airdrop) {
    this.airdrop = airdrop;
}
```

### isBotoesInterativos()
O método `isBotoesInterativos()` pertence à classe `Motorola` e retorna se os botões interativos estão disponíveis.

```java
public boolean isBotoesInterativos() {
    return botoesInterativos;
}
```

### setBotoesInterativos()
O método `setBotoesInterativos(boolean botoesInterativos)` permite alterar o valor do atributo `botoesInterativos`.

```java
public void setBotoesInterativos(boolean botoesInterativos) {
    this.botoesInterativos = botoesInterativos;
}
```

## Associação entre objetos
Na aula de **17/09/26**, foi criada uma nova classe chamada `Bateria` para realizar uma associação com a classe `Celular`. O atributo `bateria` da classe `Celular` passou a armazenar um objeto da classe `Bateria`:

```java
private Bateria bateria;
```

Essa associação permite que o `Celular` utilize os comportamentos da `Bateria`, enquanto a própria classe `Bateria` fica responsável por controlar sua porcentagem e suas regras de negócio. Com a evolução do projeto, as classes `Apple` e `Motorola` passaram a criar e receber suas próprias baterias por meio do construtor da classe `Celular`, utilizando `super()`.

Por exemplo, na classe `Apple`:

```java
super("iPhone 17 Pro Max", new Bateria(0));
```

Dessa forma, cada objeto de `Apple` ou `Motorola` possui uma `Bateria` associada ao seu próprio objeto.

## Herança (Generalização)
Na aula de **24/09/26**, foi aplicado o conceito de herança, também chamado de generalização. A classe `Celular` passou a atuar como uma superclasse, contendo características e comportamentos comuns aos diferentes tipos de celulares.

A classe `Apple` herda de `Celular`:

```java
public class Apple extends Celular {
```

E a classe `Motorola` também herda de `Celular`:

```java
public class Motorola extends Celular {
```

Por meio da herança, `Apple` e `Motorola` recebem os atributos e métodos acessíveis da classe `Celular`, podendo utilizar comportamentos como:

* `getModelo()`
* `setModelo()`
* `aumentarVolume()`
* `getVolume()`
* `carregarBateria()`
* `getBateria()`

Além disso, cada classe filha possui suas próprias características.

A classe `Apple` possui o atributo:

```java
private boolean airdrop;
```

Enquanto a classe `Motorola` possui:

```java
private boolean botoesInterativos;
```

Dessa maneira, a herança permite reutilizar características e comportamentos comuns da classe `Celular`, enquanto cada classe filha pode possuir características específicas.

## Uso do super()
Nas classes `Apple` e `Motorola`, o `super()` é utilizado para chamar o construtor da classe mãe (`Celular`).

Na classe `Apple`:

```java
public Apple() {
    super("iPhone 17 Pro Max", new Bateria(0));
    this.airdrop = true;
}
```

Na classe `Motorola`:

```java
public Motorola() {
    super("Moto G", new Bateria(0));
    this.botoesInterativos = true;
}
```

O `super()` permite que a classe filha utilize o construtor da classe mãe para inicializar as características que pertencem à estrutura de `Celular`.

Isso evita a necessidade de duplicar na classe filha a lógica de inicialização dos atributos pertencentes à classe mãe.

## Encapsulamento e herança

Os atributos das classes são privados (`private`) para proteger o estado dos objetos.

Na herança, a classe filha possui acesso aos comportamentos disponibilizados pela classe mãe, mas não acessa diretamente os atributos privados dela.

Por exemplo, `Apple` e `Motorola` não alteram diretamente os atributos privados de `Celular`. Para trabalhar com essas informações, utilizam os métodos disponibilizados pela classe mãe, como `getModelo()`, `setModelo()`, `aumentarVolume()` e `carregarBateria()`.

Assim, o conceito de encapsulamento continua sendo aplicado mesmo com a utilização da herança.

## Testes

Na aula de ********24/09/26******, o `Main.java` foi atualizado para testar os objetos das classes filhas `Apple` e `Motorola`.

Primeiramente, foi criado um objeto `Apple`:

```java
Apple apple = new Apple();
```

Depois, foram testados seu modelo, o recurso AirDrop, o volume e a bateria.

Em seguida, foi criado um objeto `Motorola`:

```java
Motorola motorola = new Motorola();
```

Também foram testados seu modelo, os botões interativos, o volume e a bateria.

A saída obtida durante a aula foi:

```text
APPLE
Modelo: iPhone 17 Pro Max
Airdrop: true
Volume: 20
Bateria: 80%

MOTOROLA
Modelo: Moto G
Botoes interativos: true
Volume: 30
Bateria: 70%
```

Os testes demonstram que as classes `Apple` e `Motorola` conseguem utilizar os comportamentos herdados de `Celular`, além de apresentarem suas próprias características.

## Projeto Celular - Pergunta de Reflexão "Clean Code" - Aula 10/09/26

********Pensando no mundo real e no Clean Code: Por que é um erro gravíssimo clicar em "Gerar Getters e Setters para tudo" automaticamente na sua IDE? Como as nossas duas decisões acima protegem o sistema de fraudes e falhas de lógica?******

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

## Projeto Celular - Pergunta de reflexão "Associação entre objetos" - Aula 17/09/26

****"No construtor da Viagem, nós exigimos o objeto inteiro (Passageiro solicitante). Se o nosso resumo só precisa imprimir o nome da pessoa, não seria mais fácil e mais leve pedir apenas a String do nome no construtor da Viagem (String nomeDoPassageiro) em vez do objeto todo?"****

****Pense nas regras de negócio: O que acontece na hora que a Viagem acaba e o sistema precisa descontar o saldo? Se a Viagem tiver apenas a String "Ana Silva", ela consegue mexer no dinheiro dela?****

Em resumo, não podemos apenar pedir a `String` do nome no construtor, pois uma `String` guarda apenas o dado e um objeto nos permite acessar os dados + comportamentos e atributos da pessoa. Por exemplo, se uma `Viagem` recebesse apenas a `String` `"Ana Silva"`, ela receberia o nome do passageiro, mas não teria acesso aos atributos do objeto `"Passageiro"` para realizar outras ações, como descontar diretamente do saldo da pessoa.

Sendo assim, neste projeto, o `Celular` passou a ter uma relação com o objeto `Bateria` e ao invés de apenas armazenar um número, a `Bateria` agora é responsável por controlar sua porcentagem e regra de comportamento. Contudo, utilizar o objeto associado permite que cada classe mantenha suas próprias responsabilidades e regras de negócio, deixando o código mais organizado

## Projeto Celular - Pergunta de reflexão "A Árvore Genealógica - Herança (Generalização)" - Aula 24/09/26

****"No nosso código, a mãe `Veiculo` possui os atributos `placa` e `modelo` como `private`. Quando o `Carro` herda de `Veiculo`, ele recebe esses atributos, mas o código dentro de Carro NÃO consegue fazer `this.placa = "ABC"`. Ele é obrigado a usar o `super()` ou o `setPlaca()`.****

****Por que o Java não deixa a filha alterar as variáveis privadas da mãe diretamente? Qual o princípio das aulas passadas que isso está protegendo?"****

O Java não permite que a classe filha altere diretamente os atributos private da classe mãe, porque esses atributos estão encapsulados e só podem ser acessados diretamente dentro da própria classe onde foram declarados. Assim, isso protege os dados de alterações indevidas e permite que a classe mãe controle como seus atributos serão modificados. Por isso, a classe filha precisa utilizar métodos como `setPlaca()` ou o construtor com `super()`, protegendo o encapsulamento, que mantém os atributos protegidos e controla o acesso a eles (princípio das aulas anteriores).

Neste projeto, isso se encaixa nos atributos da classe `Celular`, como `modelo e bateria`, que ficam protegidos pelo encapsulamento. As classes `Apple` e `Motorola`, mesmo herdando de `Celular`, não alteram esses atributos diretamente, utilizando métodos como `setModelo()` ou o construtor com `super()`. Assim, mantemos os dados protegidos e organizados dentro da estrutura de herança do projeto.

## Evolução do projeto

### 20/08/26
* Criação da classe `Celular`.
* Definição inicial dos atributos `marca`, `modelo`, `bateria` e `volume`.
* Utilização de atributos privados (`private`).
* Criação do método `aumentarVolume()`.
* Criação do método `carregarBateria()`.
* Implementação das regras para impedir valores inválidos.
* Criação do `Main.java` para testar o funcionamento do objeto.

### 10/09/26
* Criação do construtor da classe `Celular`.
* Definição de atributos essenciais para a criação do objeto.
* Utilização de métodos `set` no construtor.
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
* Aplicação do conceito de herança (generalização).
* Utilização da classe `Celular` como superclasse.
* Criação da classe `Apple` como classe filha de `Celular`.
* Criação da classe `Motorola` como classe filha de `Celular`.
* Utilização de `extends` para estabelecer a herança entre as classes.
* Utilização de `super()` para chamar o construtor da classe `Celular`.
* Definição do modelo `iPhone 17 Pro Max` para a classe `Apple`.
* Definição do modelo `Moto G` para a classe `Motorola`.
* Criação do atributo `airdrop` na classe `Apple`.
* Criação do atributo `botoesInterativos` na classe `Motorola`.
* Criação dos métodos `isAirdrop()` e `setAirdrop()` na classe `Apple`.
* Criação dos métodos `isBotoesInterativos()` e `setBotoesInterativos()` na classe `Motorola`.
* Atualização do `Main.java` para testar objetos `Apple` e `Motorola`.
* Teste dos comportamentos herdados de `Celular`, como volume e bateria.
* Teste das características específicas de cada classe filha.
* Adição da reflexão sobre herança, generalização e proteção dos atributos privados por meio do encapsulamento.