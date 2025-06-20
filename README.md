
# Minicurso: Arquitetura Limpa com Spring Boot e Gradle

Este repositório contém os códigos desenvolvidos durante o minicurso **"Arquitetura Limpa com Spring Boot e Gradle"**, onde exploramos os princípios da Clean Architecture aplicados em duas abordagens:

- **Projeto em Pacotes (Monolito Modularizado)** — uma única aplicação organizada por pacotes seguindo os princípios da arquitetura limpa.
- **Projeto Multimódulo** — separação física em módulos (domain, core, api) utilizando o Gradle.

---

## Objetivos do Minicurso

- Entender os conceitos fundamentais da **Clean Architecture**.
- Aplicar esses conceitos na prática utilizando o **Spring Boot** e o **Gradle**.
- Demonstrar as diferenças entre:
  - Organização por **pacotes** (dentro de uma única aplicação).
  - Organização por **módulos** (separação física, controle de dependências entre camadas).
- Utilizar o banco de dados **H2 em memória** para testes locais.

---

## Tecnologias e Ferramentas

- **Java 17+**
- **Spring Boot**
- **Gradle**
- **H2 Database (em memória)**
- **Lombok**
- **JUnit e Mockito (para testes)**

---

## Conceitos Aplicados

- **Princípios da Clean Architecture**
  - Independência de frameworks
  - Independência de UI
  - Independência de banco de dados
  - Separação clara entre entidades, casos de uso, gateways, controllers e serviços externos
- **Inversão de Dependências**
- **SOLID**
- **Testabilidade**

---

## Como Rodar o Projeto

### Pré-requisitos:

- JDK 17+
- Gradle instalado ou utilizar o wrapper (`./gradlew`)

### Para o projeto organizado por **pacotes**:

```bash
cd projeto-pacotes/cadastro_pessoa
./gradlew bootRun
```
Use Postman ou Insomnia para requisição POST -> localhost:8080/api/salvar com o bodyJson:
{
	"nome":"nome aqui "
}

### Para o projeto **multimódulo**:

```bash
cd projeto-multimodulo
./gradlew :api:bootRun
```

Use Postman ou Insomnia para requisição POST -> localhost:8080/api/salvar com o bodyJson:
{
	"nome":"nome aqui "
}

### Console H2 (para ambos):

- URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: *(em branco)*

---

## Executando Testes

```bash
./gradlew test
```

---

## ✍️ Autor

- **Willian Bogler**  
[LinkedIn](https://www.linkedin.com/in/willian-bogler-b82876185/)

---

## 📝 Licença

Este projeto está sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.
