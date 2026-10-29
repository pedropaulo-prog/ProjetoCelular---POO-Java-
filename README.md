# Projeto Celular - [Pedro Paulo Ferreira Agnelo D'angelo]

## Informações do Aluno
- **Nome:** [Pedro Paulo Ferreira Agnelo D'angelo]
- **RM:** [567564]
- **Turma:** [2 CCPB]
- **Curso:** [Ciências da Computação]
- **GitHub:** [@pedropaulo-prog]
---
## Descrição do Projeto
Este projeto é o resultado do aprendizado nas aulas 1-9 de Programação Orientada a Objetos, nas quais desenvolvemos um sistema de celulares utilizando os principais conceitos da linguagem Java. O projeto possui classes para representar celulares Apple e Motorola, uma classe responsável pela bateria e uma interface que define o comportamento de recarga. Durante o desenvolvimento, foram aplicados conceitos como classes e objetos, métodos, encapsulamento, construtores, associação, herança, polimorfismo, classes abstratas e interfaces, onde o objetivo foi compreender como organizar o código, reutilizar funcionalidades e estabelecer regras para o funcionamento dos objetos.

---
## Checklist de Implementação
- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [x] Aula 9 - Interfaces
---
## Perguntas de Reflexão
### Aula 1 - Classes e Objetos
**Pergunta:** "**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Não seria mais fácil apenas criar variáveis soltas no main, como `String nomeAna = "Ana"` e `double saldoAna = 50.0`?
**Pense:** E se o FiapRide tiver 1 milhão de usuários? Como a Classe ajuda a resolver isso?"

**Sua Resposta:**
Criar uma classe permite organizar os dados e comportamentos de algo em uma única estrutura e, no nosso projeto, a classe Celular representa as características e ações que um celular possui, como modelo, volume e bateria. Se utilizássemos apenas variáveis soltas, o código ficaria desorganizado e difícil de manter, principalmente com muitos objetos. Com as classes, podemos criar vários celulares a partir de uma estrutura comum, mantendo cada objeto com seus próprios dados. Isso facilita a reutilização do código e a organização do sistema.
---
### Aula 2 - Métodos
**Pergunta:** "Se nós podemos simplesmente fazer `passageiro.saldo = passageiro.saldo \+ 100` diretamente no código principal, por que dá tanto trabalho criar um método específico chamado `adicionarSaldo\(valor\)` para fazer isso? Quais seriam os riscos para a nossa startup de mobilidade se deixássemos qualquer programador alterar o saldo diretamente?"

**Sua Resposta:**
Se alterássemos o saldo diretamente no código principal, qualquer programador poderia modificar seu valor sem respeitar regras de negócio. Por exemplo, seria possível adicionar dinheiro indevidamente ou realizar alterações que não deveriam ser permitidas. Ao criar um método específico, como `adicionarSaldo(valor)`, podemos centralizar as regras de alteração e controlar melhor o que acontece com o saldo, evitando fraudes e falhas de lógica.

No Projeto Celular, aplicamos esse mesmo princípio ao encapsulamento. Os atributos são privados (`private`), impedindo o acesso direto a eles fora da própria classe. Além disso, métodos como `carregar()` verificam se a quantidade informada é positiva e se a bateria não ultrapassará 100%. Dessa forma, protegemos os dados dos objetos e garantimos que suas alterações respeitem as regras definidas no código.
---
### Aula 3 - Encapsulamento
**Pergunta:** "No nosso código, os atributos são `private`, mas os métodos `getSaldo\(\)` e `get Nome\(\)` são `public`. Por que é seguro deixar o `get` público, mas perigoso deixar o atributo original público?
Pense bem: Qual a diferença entre dar a alguém uma CÓPIA de um documento seu, e entregar o documento ORIGINAL para a pessoa rasurar?"

**Sua Resposta:**
Os métodos `get` são públicos porque permitem consultar as informações de um objeto sem dar acesso direto ao atributo original. É como entregar uma cópia de um documento: a pessoa pode ler as informações, mas não consegue alterar o documento original por meio dessa cópia. Se os atributos fossem públicos, qualquer parte do código poderia modificá-los diretamente, sem respeitar as regras definidas pela classe.

No nosso Projeto Celular, utilizamos atributos privados (`private`) e métodos públicos, como `getModelo()` e `getVolume()`, para permitir a consulta dessas informações com segurança. Além disso, a bateria possui o método `getPorcentagem()`, enquanto sua alteração é feita pelo método `carregar()`, que verifica se a quantidade informada é válida e impede que a carga ultrapasse 100%. Assim, protegemos os dados dos objetos e mantemos o controle sobre as alterações.

---
### Aula 4 - Construtores
**Pergunta:** "> "Na nossa classe `Veiculo`, nós tomamos duas decisões arquitetônicas muito importantes:
> 1. Nós **não** criamos o método `setModelo\(\)`.
> 2. O `setPlaca\(\)` foi criado como **privado**, e criamos um método público chamado `atualizarPlaca\(\)` para acessá-lo.
> Pensando no mundo real e no Clean Code: Por que é um erro gravíssimo clicar em 'Gerar Getters e Setters para tudo' automaticamente na sua IDE? Como as nossas duas decisões acima protegem o s istema de fraudes e falhas de lógica?"
Dica: Pense sobre o que pode ou não mudar fisicamente em um carro, e a diferença entre "alterar um dado no banco" e "executar um processo real no Detran"

**Sua Resposta:**
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
---
### Aula 5 - Associação
**Pergunta:** ""No construtor da `Viagem`, nós exigimos o objeto inteiro \(`Passageiro solicitante`\). Se o nosso resumo só precisa imprimir o nome da pessoa, não seria mais fácil e mais leve pedir apenas a String do nome no construtor da Viagem \(`String nomeDoPassageiro`\) em vez do objeto todo?"

Pense nas regras de negócio: O que acontece na hora que a Viagem acaba e o sistema precisa descontar o saldo? Se a Viagem tiver apenas a String "Ana Silva", ela consegue mexer no dinheiro dela?"

**Sua Resposta:**
Em resumo, não podemos apenar pedir a `String` do nome no construtor, pois uma `String` guarda apenas o dado e um objeto nos permite acessar os dados + comportamentos e atributos da pessoa. Por exemplo, se uma `Viagem` recebesse apenas a `String` `"Ana Silva"`, ela receberia o nome do passageiro, mas não teria acesso aos atributos do objeto `Passageiro` para realizar outras ações, como descontar diretamente do saldo da pessoa.

Sendo assim, neste projeto, o `Celular` passou a ter uma relação com o objeto `Bateria` e ao invés de apenas armazenar um número, a `Bateria` agora é responsável por controlar sua porcentagem e regra de comportamento. Contudo, utilizar o objeto associado permite que cada classe mantenha suas próprias responsabilidades e regras de negócio, deixando o código mais organizado.
---
### Aula 6 - Herança
**Pergunta:** ""No nosso código, a mãe `Veiculo` possui os atributos `placa` e `modelo` como `private`. Quando o `Carro` herda de `Veiculo`, ele recebe esses atributos, mas o código dentro de `Carro` NÃO consegue fazer `this.placa = "ABC"`. Ele é obrigado a usar o `super\(\)` ou o `setPlaca\(\)`.

Por que o Java não deixa a filha alterar as variáveis privadas da mãe diretamente? Qual o princípio das aulas passadas que isso está protegendo?""

**Sua Resposta:**
O Java não permite que a classe filha altere diretamente os atributos private da classe mãe, porque esses atributos estão encapsulados e só podem ser acessados diretamente dentro da própria classe onde foram declarados. Assim, isso protege os dados de alterações indevidas e permite que a classe mãe controle como seus atributos serão modificados. Por isso, a classe filha precisa utilizar métodos como `setPlaca()` ou o construtor com `super()`, protegendo o encapsulamento, que mantém os atributos protegidos e controla o acesso a eles (princípio das aulas anteriores).

Neste projeto, isso se encaixa nos atributos da classe `Celular`, como `modelo` e `bateria`, que ficam protegidos pelo encapsulamento. As classes `Apple` e `Motorola`, mesmo herdando de `Celular`, não alteram esses atributos diretamente, utilizando métodos como `setModelo()` ou o construtor com `super()`. Assim, mantemos os dados protegidos e organizados dentro da estrutura de herança do projeto.
---
### Aula 7 - Polimorfismo
**Pergunta:** "No nosso loop `for \(Veiculo veiculo : frota\)`, a variável `veiculo` é do tipo genérico `Veiculo`. Se esquecêssemos de criar o método `calcularAutonomia\(\)` lá na classe mãe `Veiculo`, nós conseguiríamos chamá-lo dentro do loop, mesmo sabendo que ele existe dentro do `Carro` e da `Moto`? Por que o contrato precisa existir na base da hierarquia?"

**Sua Resposta:**
A variável `veiculo` é do tipo `Veiculo`, então ela só consegue acessar os métodos que existem na classe `Veiculo`. Mesmo que `Carro` e `Moto` possuam o método `calcularAutonomia()`, não seria possível chamá-lo pelo `veiculo` se esse método não existisse na classe mãe. O contrato precisa existir na classe base porque ele garante que todas as classes filhas terão esse comportamento. Assim, o loop pode trabalhar com qualquer objeto do tipo `Veiculo` e o polimorfismo permite que cada classe filha execute sua própria implementação do método.

Nesse projeto, isso acontece de forma semelhante com o método `tocarSom()`. O método foi criado na classe `Celular`, que é a classe mãe, e depois foi sobrescrito nas classes `Apple` e `Motorola`. Por isso, na nossa lista `List<Celular>`, podemos percorrer os objetos usando uma variável do tipo `Celular` e chamar `celular.tocarSom()`. Mesmo sendo do tipo `Celular`, cada objeto executa a sua própria versão do método: o `Apple` executa "Som do iPhone" e o `Motorola` executa "Som do Motorola".
---
### Aula 8 - Classes Abstratas
**Pergunta:** "Pense no mundo real: Faz sentido existir um objeto que é APENAS 'Veículo' sem ser um tipo específico? Você já entrou em uma concessionária e comprou "um veículo" genérico, sem ser carro, moto, caminhão ou nada disso? Por que, então, no código, precisamos EXPLICITAMENTE dizer ao Java que `Veiculo` é `abstract`? Por que ele não deduz isso sozinho?

Pense: Se esquecermos de colocar `abstract`, qual o risco que corremos? Alguém pode criar `new V
eiculo\(\)` e quebrar a lógica do nosso sistema?"

**Sua Resposta:**
No mundo real, não faz muito sentido comprar apenas um "veículo" genérico, pois normalmente compramos um tipo específico, como um carro ou uma moto. No nosso projeto, acontece algo semelhante: não criamos um celular genérico, mas sim objetos específicos das classes `Apple` e `Motorola`. Por isso, precisamos declarar `Celular` como `abstract`, indicando ao Java que essa classe serve como um modelo para as classes filhas, e não para criar objetos diretamente. O Java não deduz isso sozinho porque precisamos informar explicitamente essa intenção no código.

Se esquecermos de colocar `abstract`, alguém poderá criar um objeto diretamente com `new Celular()`, mesmo que a intenção do projeto seja trabalhar apenas com tipos específicos de celulares. Isso permitiria criar um objeto genérico e poderia comprometer a lógica que queremos estabelecer. Ao tornar a classe abstrata, impedimos essa criação direta e garantimos que os objetos sejam instanciados por meio de classes concretas, como `Apple` e `Motorola`.
---
### Aula 9 - Interfaces
**Pergunta:** "Por que Java permite herança simples \(apenas uma mãe\), mas múltipla implementação de interfaces \(vários contratos\)?
Pense: Se `CarroEletrico` pudesse herdar de `Veiculo` e de `Bateria` ao mesmo tempo \(herança múltipla\), o que aconteceria se AMBAS as mães tivessem um método chamado `ligar\(\)`? Como as interfaces resolvem esse problema?"

**Sua Resposta:**
O Java permite que uma classe herde diretamente de apenas uma classe, evitando ambiguidades que poderiam surgir quando duas classes mães definissem implementações conflitantes para os mesmos métodos. As interfaces permitem estabelecer contratos de comportamento que uma classe pode implementar, sem exigir que ela herde de várias classes. No nosso projeto, criamos a interface Recarregavel, que define o método recarregar(int percentual) e as constantes CARGA_MAXIMA e CARGA_MINIMA. A classe Celular implementa essa interface, permitindo que os celulares utilizem o comportamento de recarga por meio de um contrato comum.
---
## Desafios Técnicos Implementados
### Desafio Pessoal (Seu Projeto)
**Qual foi o domínio que você escolheu para seu projeto pessoal?**
O domínio escolhido foi de dispositivos móveis, especificamente celulares, onde desenvolvi um sistema java para representá-los em diferentes marcas e funcionalidades.

**Quais classes você criou?**
- **Main:** classe principal responsável por executar os testes.
- **Celular:** classe abstrata que define características e comportamentos comuns aos celulares.
- **Apple:** classe que representa um celular Apple.
- **Motorola:** classe que representa um celular Motorola.
- **Bateria:** classe responsável por controlar a porcentagem de carga.
- **Recarregavel:** interface que define o contrato de recarga dos celulares.

**Qual foi o maior desafio técnico que você enfrentou?**
O maior desafio técnico que enfrentei foi conectar o meu projeto com o do Gabriel, pois nossos objetos eram diferentes e precisei entender como fazer os dois funcionarem juntos. No começo, fiquei com dúvidas sobre quais arquivos precisava alterar para que a integração funcionasse corretamente e a parte mais importante foi entender como utilizar a interface `Recarregavel` para que tanto os celulares quanto o carro elétrico do Gabriel pudessem ser recarregados pelo mesmo código. Além disso, ele precisou criar a classe `Tesla` para que pudéssemos utilizar a mesma interface nos dois projetos. 

Durante esse processo, encontrei alguns erros que me fizeram revisar as classes e verificar o que estava faltando e um dos problemas aconteceu porque eu não tinha feito as alterações necessárias no arquivo `Carro.java` para que `Tesla.java` funcionasse corretamente. Depois de corrigir isso, consegui executar o programa e ver os três objetos sendo recarregados para 85%, além de ajustar a mensagem exibida pelo Tesla para deixar o resultado mais claro. Essa experiência me ajudou a entender melhor como as interfaces permitem trabalhar com objetos de classes diferentes e, no final, percebi que é importante saber analisar os erros e compreender como cada parte do projeto se conecta, não somente escrever o código.
---
## Conclusão
**O que você aprendeu nestas 9 aulas?**
Durante estas nove aulas, aprendi a estruturar programas utilizando os conceitos fundamentais da Programação Orientada a Objetos em Java, onde compreendi como criar classes e objetos, definir métodos, utilizar construtores e proteger informações por meio do encapsulamento, além de outros conceitos vistos em aula. Ao desenvolver o Projeto Celular, consegui aplicar esses conceitos de maneira prática e entender melhor como eles se complementam na construção de um programa.

**Qual conceito foi mais difícil de entender?**
O conceito que tive mais dificuldade de compreender foi a herança, pois precisei fazer diversas alterações no meu projeto para aplicá-la. Percebi que criar uma superclasse e suas classes filhas exige mais planejamento do que simplesmente criar várias classes que repetem o mesmo código, pois precisei conectar as classes Apple e Motorola por meio da classe Celular. Entretanto, compreendi a importância desse conceito, pois ele permite organizar melhor a estrutura do código, reutilizar funcionalidades e evitar repetições desnecessárias, contribuindo para um código mais limpo e organizado, de acordo com os princípios do Clean Code.

**O que você melhoraria no seu projeto se pudesse refazer?**
Se pudesse refazer o projeto, melhoraria a validação dos dados para garantir que os objetos não recebessem valores inválidos, além de adicionar novas funcionalidades, como diferentes modelos de celulares e outras operações relacionadas à bateria. Assim, também revisaria a estrutura das classes para manter cada responsabilidade bem definida e evitar repetições desnecessárias. Tornando o código mais robusto, organizado e fácil de ampliar no futuro.

**## Evolução do projeto (commits)**

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

### 15/10/26 - Aula 8

* Transformação da classe `Celular` em uma classe abstrata utilizando `abstract`.
* Declaração do método abstrato `tipoDeConector()` na classe `Celular`.
* Implementação obrigatória do método `tipoDeConector()` nas classes filhas.
* Implementação do método `tipoDeConector()` na classe `Apple`, retornando `"Lightning"`.
* Implementação do método `tipoDeConector()` na classe `Motorola`, retornando `"USB-C"`.
* Aplicação dos conceitos de classes abstratas e métodos abstratos.
* Atualização do `Main.java` para testar os conectores dos celulares.
* Manutenção da lista polimórfica utilizando `List<Celular>`.
* Adição da reflexão sobre classes abstratas e a necessidade de impedir a instanciação direta da classe mãe.

### 29/10/26 - Aula 9

* Criação da interface `Recarregavel`.
* Declaração do método `recarregar(int percentual)` na interface `Recarregavel`.
* Criação das constantes `CARGA_MAXIMA` e `CARGA_MINIMA` na interface.
* Implementação da interface `Recarregavel` na classe abstrata `Celular`, utilizando `implements`.
* Implementação do método `recarregar()` na classe `Celular`.
* Aplicação de validação para impedir percentuais de recarga inválidos.
* Utilização das constantes da interface para validar os valores informados.
* Atualização do `Main.java` para testar a recarga dos celulares por meio da interface.
* Criação de um array do tipo `Recarregavel` contendo os objetos `Apple`, `Motorola` e `Tesla`.
* Integração do projeto com o código do Gabriel para permitir que celulares e um carro elétrico utilizem a mesma interface.
* Utilização de um `for` para percorrer os objetos e executar o método `recarregar()`.
* Teste da recarga dos três objetos para 85%.
* Atualização da classe `Tesla` para exibir uma mensagem após a recarga.
* Teste de valor inválido utilizando o percentual de 120%.
* Aplicação dos conceitos de interfaces, contratos de comportamento e polimorfismo.
* Adição da reflexão sobre a implementação de interfaces e suas diferenças em relação à herança.