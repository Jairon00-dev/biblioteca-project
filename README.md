# 📚 Sistema de Biblioteca Pública

Projeto desenvolvido em Java utilizando Spring Boot com foco no gerenciamento de uma biblioteca pública/escolar.

O sistema permite o controle de livros, usuários e empréstimos, além de possuir uma funcionalidade adicional de auditoria responsável
por registrar automaticamente as operações realizadas na aplicação.

---

# 🚀 Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Swagger/OpenAPI
* Lombok
* Maven

---

# 🏗️ Estrutura do Projeto

```text
src/main/java/com/projeto/biblioteca/backend

├── controller
├── domain
│   ├── dto
│   └── model
├── repository
├── service
└── utils
```

---

# 📘 Funcionalidades

## 📚 CRUD de Livros

Permite:

* cadastrar livros
* listar livros
* buscar livro por ID
* remover livros

Campos principais:

* id
* titulo
* autor
* genero
* quantidadeDisponivel

---

## 👤 CRUD de Usuários

Permite:

* cadastrar usuários
* listar usuários
* buscar usuário por ID
* remover usuários

Campos principais:

* id
* nome
* email
* tipo

---

## 📦 CRUD de Empréstimos

Permite:

* registrar empréstimos
* listar empréstimos
* buscar empréstimo por ID
* remover empréstimos

---

## 📂 CRUD de Categorias

Permite:
- cadastrar categorias
- listar categorias
- buscar categoria por ID
- remover categorias

Campos principais:
- id
- nome
  
---

## 🔔 CRUD de Notificações

Permite:
- cadastrar notificações
- listar notificações
- buscar notificação por ID
- remover notificações

Campos principais:
- id
- mensagem
- dataEnvio
  
---

# 🔍 Funcionalidade Adicional — Auditoria

O sistema possui uma funcionalidade de auditoria responsável por registrar automaticamente ações importantes realizadas na aplicação.

As auditorias são persistidas no banco de dados e armazenam:

* ação realizada
* entidade afetada
* descrição da operação
* data da operação

Exemplos:

* criação de livros
* remoção de usuários
* registro de empréstimos

---

# 🗄️ Banco de Dados

O projeto utiliza PostgreSQL.

Configuração no arquivo:

```properties
application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca
spring.datasource.username=postgres
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# 🌐 Swagger

A documentação da API pode ser acessada através do Swagger.

URLs:

```text
http://localhost:8080/swagger-ui.html
```

ou

```text
http://localhost:8080/swagger-ui/index.html
```

---

# ▶️ Como Executar o Projeto

## 1. Clonar o repositório

```bash
git clone <url-do-repositorio>
```

---

## 2. Abrir no IntelliJ

Abrir a pasta do projeto no IntelliJ IDEA.

---

## 3. Configurar o PostgreSQL

Criar um banco chamado:

```text
biblioteca
```

---

## 4. Configurar o application.properties

Inserir usuário e senha do PostgreSQL.

---

## 5. Executar o projeto

Rodar a classe principal do Spring Boot.
```text
BibliotecaApplication.java
```
---

# 🧪 Testes

Os testes da API podem ser realizados diretamente pelo Swagger.

Fluxo recomendado:

1. cadastrar usuário
2. cadastrar livro
3. registrar empréstimo
4. verificar auditoria no banco

---

# 📌 Exemplo de Auditoria no Banco

| id | acao   | entidade | descricao                |
| -- | ------ | -------- | ------------------------ |
| 1  | CREATE | Livro    | Livro criado: Clean Code |
| 2  | DELETE | Usuario  | Usuário removido ID: 1   |

---

# 📖 Objetivo Acadêmico

O projeto foi desenvolvido com fins acadêmicos para aplicação prática de conceitos relacionados a:

* APIs REST
* arquitetura em camadas
* persistência de dados
* DTOs
* auditoria de operações
* integração com banco de dados
* documentação de APIs

---

# 👨‍💻 Desenvolvedor

Jairon Alves Holanda Filho.
