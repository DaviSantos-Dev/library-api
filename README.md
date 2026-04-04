# 📚 Library API

## 🧠 Sobre o projeto

Este projeto foi desenvolvido como minha **primeira API utilizando Spring Boot**, com o objetivo de consolidar os fundamentos de:

* Spring Web
* Spring Data JPA
* Estruturação de aplicações backend
* Regras de negócio simples

> ⚠️ Este é um **projeto de aprendizado**, onde o foco foi entender o funcionamento do ecossistema Spring na prática.

---

## 🎯 Objetivo

Construir uma API REST simples para gerenciamento de:

* Livros
* Empréstimos

Aplicando regras básicas de negócio e persistência em banco de dados.

---

## ⚙️ Tecnologias utilizadas

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* H2 Database

---

## 📦 Funcionalidades

### 📚 Livro

* Criar livro
* Listar livros
* Buscar por ID
* Atualizar livro
* Remover livro

---

### 🔄 Empréstimo

* Criar empréstimo
* Listar empréstimos
* Buscar empréstimo por ID
* Devolver livro

---

## 📏 Regras de negócio

* Um livro só pode ser emprestado se estiver disponível
* Ao ser emprestado, o livro fica indisponível
* Ao ser devolvido, o livro volta a ficar disponível
* Um empréstimo não pode ser finalizado duas vezes

---

## 🧱 Estrutura do projeto

O projeto segue uma arquitetura em camadas:

```
controller → service → repository → entity
```

* **Controller** → recebe as requisições HTTP
* **Service** → contém as regras de negócio
* **Repository** → acesso ao banco de dados
* **Entity** → representação das tabelas

---

## 🧠 Aprendizados

Durante o desenvolvimento, foram trabalhados conceitos importantes como:

* Injeção de dependência
* Uso de anotações do Spring
* Ciclo básico de uma aplicação Spring Boot
* Tratamento de exceções com `orElseThrow`
* Relacionamento entre entidades (JPA)
* Separação de responsabilidades (camadas)

---

## ⚠️ Observações

* Algumas decisões de implementação foram mantidas propositalmente para refletir meu nível no momento do desenvolvimento
* O projeto foi feito com foco em aprendizado, não em arquitetura final de produção
* Melhorias serão aplicadas em projetos futuros conforme evolução técnica

---

## 📌 Status

✔️ Concluído como projeto de aprendizado

📈 Base para evolução em projetos futuros com Spring Boot

---

## 💬 Considerações finais

Este projeto marca o início da minha prática com Spring Boot.

O foco foi consolidar fundamentos importantes de desenvolvimento backend, priorizando entendimento prático sobre complexidade desnecessária.


## ▶️ Como executar

### Pré-requisitos
- JDK 21
- IDE (preferencialmente IntelliJ)
- Postman ou Insomnia

### Passos

```bash
# Clonar repositório
git clone https://github.com/seu-user/library-api.git

# Entrar na pasta
cd library-api

# Rodar aplicação
./mvnw spring-boot:run