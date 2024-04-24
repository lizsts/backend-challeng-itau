#  API REST para Desafio Técnico Backend - Itaú Seguros

Este projeto apresenta uma API REST que tem como objetivo construir o cálculo do preço tarifado de um Produto de Seguros, tendo como referência um Preço Base e uma Categoria de seguros.

 O padrão de arquitetura seguiu as premissas de Clean Architecture, sendo as camadas: 

- Core: Onde estão os useCases e model (enterprise object). 
- Infrastructure: Contém acesso ao Controller, lógica de persistência, presenters e uma implementação de um serviceGateway, cuja interface é disponibilizada no package application para ser utilizada pelos casos de uso.
- Application: Responsável para garantir o intermédio entre as camadas core e infrastructure, garantindo o contrato do Gateway e as Constants utilizadas na lógica do cálculo.

![Clean-Architecture-3](https://user-images.githubusercontent.com/2626931/155764857-df7e36e7-4a76-41bb-bea6-a55be043f782.png)

## Instalando e Executando a Aplicação:

Clone o projeto no repositório: 

```bash
git clone https://github.com/lizsts/backend-challenge-itau.git
```
Faça checkout para branch Desenv:

```bash
git checkout desenv
```
Na pasta raiz do projeto, execute o comando com maven para limpar e instalar: 

```bash
mvn clean install
```
Logo depois, para inicializar a Aplicação, utilize o maven plugin para spring-boot com o seguinte comando:
```bash
mvn spring-boot:run
```
OBS: Certifique-se de que tem o JDK 17 instalado em sua máquina, caso não tenha, pode obter
através do [link](https://jdk.java.net/archive/). 
## Fazendo Requisições HTTP com Swagger:

Após o start da aplicação, você pode acessar a interface [Swagger UI](http://localhost:8082/swagger-ui.html) e utilizar no método POST o seguinte body: 

```json
{
    "name": "Seguro de Vida Individual",
    "category": "VIDA",
    "basePrice": 100.00
}
```
As Categorias podem ser: "VIDA", "AUTO", "VIAGEM", "RESIDENCIAL", "PATRIMONIAL".

OBS: Caso digite uma categoria diferente das citadas acima, a API lança uma exceção (InvalidCategoryException). 


## Tecnologias Utilizadas: 

* [Java 17 - JDK](https://jdk.java.net/17/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/)
* [Spring Boot Actuator](https://www.baeldung.com/spring-boot-actuators)
* [JaCoCo Maven Plugin](https://www.eclemma.org/jacoco/trunk/doc/maven.html)

### Banco de Dados: 
Para simplificar a solução, foi utilizado o H2 como banco de dados. Para testar sua correta conexão, foi criado um teste de integração com a persistência da entidade com repository.

Pode ser acessado o [H2 Console](http://localhost:8082/h2-console), utilizando as credenciais disponíveis no application.yml.

### Observabilidade: 
Com Spring Boot Actuator, podem ser acessados os dados através dos endpoints: 
* [Health](http://localhost:8082/management/health)
* [Metrics](http://localhost:8082/management/metrics)

OBS: O Actuator garante suporte para integração com interfaces de métricas como DynaTrace, Grafana, entre outras. 

### Code Coverage:

É possível a partir da pasta raiz do projeto acessar, para uma visualização dos relatórios de cobertura de testes com JaCoCo: 
```bash
/target/site/index.html
```


## Justificando a Solução: 

#### Design Patterns - Strategy: 
Foi adotado o padrão de projeto Strategy para delinear as diferentes estratégias de cálculo com base em cada categoria. A fórmula para o cálculo é agnóstica, porém os valores das taxas referentes a cada Categoria são diferentes. Sendo assim, foram guardados como Constants com um Map de chave e valor para cada categoria com seus respectivos impostos. Essa escolha foi necessária uma vez que Categoria não pôde ser uma entidade persistida num banco. O que facilitaria para usar um design criacional do tipo Factory, por exemplo.

#### UseCases:

Como requisito do desafio, um único endpoint de POST poderia criar um novo Produto ou atualizar um já existente. Para isso, foram criados casos de uso nos quais, dependendo de uma validação pelo nome do Produto, é possível atualizá-lo (se já existir) ou criar um novo.

Uma dica para a evolução da solução: O Command Patterns (createCommandProduct e updateCommandProduct, por exemplo) seria uma boa escolha, em um momento no qual seja possível reverter uma chamada de atualização e salvar um histórico dos comandos utilizados. Não foi adotado nessa solução, pois ainda se trata de operações simples e os useCases são efetivos nesse caso, garantindo princípios como responsabilidade única e desacoplamento para operações únicas e pouco complexas, como as especificadas. 

#### ServiceGateway:

Criei um service para lidar com operações de acesso a repository e persistência, posto que os meus useCases não poderiam acessar as camadas de infrastructure diretamente sem prejudicar o modelo de uma arquitetura limpa. Para isso, deixo disponível para minha camada core uma interface, garantindo a separação de responsabilidades, a manutenibilidade e flexibilidade da minha aplicação.

## Considerações Finais: 
Esta solução apresenta ainda alguns débitos que gostaria de trabalhar. Como a evolução para a utilização de um banco de dados PostgreSQL, Testes de Containers para Database, Configuração para build com GitHub Actions, melhorias na Cobertura de Testes e novos tratamento de exceções, com melhores refinamentos.

## Referências:

* [The Clean Code Blog](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
* [Refactoring Guru - Strategy](https://refactoring.guru/pt-br/design-patterns/strategy)
