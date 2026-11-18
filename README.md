# Pet Bem-Estar

<p align="center">
  <img src="src/main/resources/static/images/logo.jpg" alt="Logo Pet Bem-Estar" width="900" />
</p>

## Descrição do Projeto

O **Pet Bem-Estar** é uma aplicação web desenvolvida em Java com Spring Boot para o gerenciamento de um pet shop / clínica veterinária. O sistema permite organizar o cadastro de clientes (tutores) e seus respectivos animais de estimação de forma simples e segura, contando com autenticação de usuários e persistência em banco de dados MySQL.

## Funcionalidades

- **Autenticação de Usuários:** Cadastro de novos usuários, login e logout com proteção de rotas via interceptor e criptografia de senhas.
- **Gerenciamento de Clientes:** Listagem, cadastro, visualização de detalhes, edição e remoção de clientes.
- **Gerenciamento de Animais (Pets):** Cadastro, listagem, edição e remoção de animais vinculados aos seus respectivos clientes, com suporte a espécie e porte.
- **API/Rotas de Tutores:** Gerenciamento e consulta de tutores.

## Acesso ao Projeto

### Pré-requisitos

- **Java 17** ou superior
- **MySQL** em execução na porta `3306`
- **Git** (para clonar o repositório)

### Passo a passo para rodar localmente

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/jpzxcf/pet-bem-estar-novo.git
   cd pet-bem-estar-novo
   ```

2. **Configure o banco de dados:**
   Certifique-se de que o MySQL está ativo. O projeto já cria o banco `petbemestar_spring` automaticamente caso não exista. Se necessário, ajuste usuário e senha em [`src/main/resources/application.properties`](src/main/resources/application.properties):
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/petbemestar_spring?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
   spring.datasource.username=root
   spring.datasource.password=admin
   ```

3. **Execute a aplicação usando o Maven Wrapper:**
   - **Windows (PowerShell/CMD):**
     ```cmd
     .\mvnw.cmd spring-boot:run
     ```
   - **Linux/macOS:**
     ```bash
     ./mvnw spring-boot:run
     ```

4. **Acesse no navegador:**
   Abra `http://localhost:8080` para utilizar o sistema (ou `http://localhost:8080/login`).



## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** (Web MVC, Data JPA, Thymeleaf, Validation)
- **Spring Security Crypto** (criptografia de senhas)
- **Hibernate / JPA**
- **MySQL** (`mysql-connector-j`)
- **Thymeleaf**, **HTML5** e **CSS3**
- **Maven** (com Maven Wrapper)
