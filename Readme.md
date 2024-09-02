# Microsserviço de Gerenciamento de Propostas de Análise de Crédito - ACR Financeira

## Descrição do Projeto

Este projeto é um microsserviço desenvolvido para a ACR Financeira, que atua no ramo financeiro concedendo empréstimos para pessoas físicas. O microsserviço permite o cadastro de clientes e suas solicitações de empréstimo para posterior análise de crédito. Nesta fase do desenvolvimento, a aplicação realiza o CRUD completo para a entidade `User` e operações de cadastro e consulta para a entidade `Proposta`.

## Funcionalidades

- **CRUD de Usuários**: Permite a criação, leitura, atualização e exclusão de usuários no sistema.
- **Cadastro de Propostas**: Permite o cadastro de propostas de crédito associadas a um usuário.
- **Consulta de Propostas**: Permite a consulta de todas as propostas ou de uma proposta específica por ID.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação utilizada.
- **Spring Boot 3.3.3**: Framework para simplificar o desenvolvimento de aplicações Java.
- **Maven**: Gerenciador de dependências e build da aplicação.
- **H2 Database**: Banco de dados em memória utilizado para desenvolvimento e testes.
- **Spring Data JPA**: Framework para simplificar a interação com o banco de dados.
- **Lombok**: Biblioteca para reduzir a quantidade de código boilerplate.

## Estrutura do Projeto

- **Model**: Contém as classes de domínio (`User`, `Proposta`).
- **DTO**: Contém os Data Transfer Objects utilizados para transferência de dados entre as camadas.
- **Repository**: Contém as interfaces para interação com o banco de dados.
- **Service**: Contém a lógica de negócio e as operações que manipulam os dados.
- **Controller**: Contém os endpoints REST que expõem as funcionalidades do microsserviço.

## Configuração do Projeto

1. Clone o repositório:
    ```bash
    git clone https://github.com/EnzoGalati12/ms-proposta.git
    ```


## Configurações da Aplicação

- **application.properties**: Configurações gerais da aplicação.
- **application-test.properties**: Configurações do perfil de teste utilizando o banco de dados H2.

## Como Utilizar

1. **CRUD de Usuários**:
    - **GET** `/users`: Retorna todos os usuários cadastrados.
    - **GET** `/users/{id}`: Retorna um usuário específico pelo ID.
    - **POST** `/users`: Cadastra um novo usuário.
    - **PUT** `/users/{id}`: Atualiza os dados de um usuário existente.
    - **DELETE** `/users/{id}`: Remove um usuário do sistema.

2. **Cadastro e Consulta de Propostas**:
    - **GET** `/propostas`: Retorna todas as propostas cadastradas.
    - **GET** `/propostas/{id}`: Retorna uma proposta específica pelo ID.
    - **POST** `/propostas`: Cadastra uma nova proposta de crédito.
    - **DELETE** `/propostas/{id}`: Remove uma proposta do sistema.

## Seed do Banco de Dados

Um arquivo `import.sql` foi criado para inicializar o banco de dados com dados de teste, incluindo três usuários distintos e duas propostas para cada usuário.

## Testes

Um arquivo JSON de exemplo (`exemplo-proposta.json`) foi incluído na raiz do projeto para facilitar a realização de testes. Utilize-o para simular o cadastro de uma nova proposta.

## Autor(es)

- **Luigi de Lima Galati** - Desenvolvimento e implementação do projeto.
- **Enzo de Lima Galati** - Desenvolvimento e implementação do projeto.

## Licença

Este projeto é de uso acadêmico e foi desenvolvido como parte de um desafio educacional.
