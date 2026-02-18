# 💰 PicPay Simplificado

Projeto desenvolvido para treinar conceitos de transações financeiras, notificações, autorização e testes unitários com JUnit e Mockito.

## 📋 Sobre o Projeto

Este é um sistema simplificado de transações financeiras inspirado no PicPay, desenvolvido com Spring Boot. O projeto implementa funcionalidades essenciais de transferência de valores entre usuários, com validações, autorizações e notificações.

## 🎯 Objetivos de Aprendizado

- ✅ Implementação de transações financeiras
- ✅ Sistema de notificações
- ✅ Serviço de autorização de transações
- ✅ Testes unitários com JUnit e Mockito
- ✅ Arquitetura em camadas (Controller, Service, Repository)
- ✅ Integração com APIs externas

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.9**
- **Spring Data JPA**
- **H2 Database** (banco de dados em memória)
- **Lombok**
- **JUnit 5** (testes unitários)
- **Mockito** (mocks para testes)
- **Maven** (gerenciamento de dependências)

## 📁 Estrutura do Projeto

```
picpaysimplificado/
├── src/
│   ├── main/
│   │   ├── java/com/picpaysimplificado/
│   │   │   ├── Controller/
│   │   │   │   ├── TransactionController.java
│   │   │   │   └── UserController.java
│   │   │   ├── service/
│   │   │   │   ├── TransactionService.java
│   │   │   │   ├── UserService.java
│   │   │   │   ├── NotificationService.java
│   │   │   │   └── AuthorizationService.java
│   │   │   ├── repositories/
│   │   │   ├── domain/
│   │   │   └── dtos/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/picpaysimplificado/
│           ├── service/
│           │   └── TransactionServiceTest.java
│           └── repositories/
│               └── UserRepositoryTest.java
└── pom.xml
```

## 🔧 Funcionalidades Principais

### 1. Transações Financeiras
- Transferência de valores entre usuários
- Validação de saldo
- Atualização automática de saldos
- Registro de histórico de transações

### 2. Sistema de Autorização
- Validação de transações antes da execução
- Integração com serviço externo de autorização
- Tratamento de falhas de autorização

### 3. Sistema de Notificações
- Notificação ao remetente após transação
- Notificação ao destinatário ao receber valores
- Integração com API externa de notificações
- Tratamento de falhas no envio

### 4. Testes Unitários
- Testes de serviços com JUnit 5
- Mocks com Mockito
- Cobertura de cenários de sucesso e falha
- Testes de repositórios

## ⚙️ Configuração e Execução

### Pré-requisitos
- Java 21 ou superior
- Maven 3.6+

### Instalação

1. Clone o repositório:
```bash
git clone <url-do-repositorio>
cd picpaysimplificado
```

2. Execute o projeto:
```bash
mvnw spring-boot:run
```

Ou no Windows:
```bash
mvnw.cmd spring-boot:run
```

3. A aplicação estará disponível em: `http://localhost:8080`

### Banco de Dados H2

O console do H2 está habilitado e pode ser acessado em:
- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:file:./data/testdb`
- **Username**: `sa`
- **Password**: (vazio)

## 🧪 Executando os Testes

Para executar todos os testes unitários:

```bash
mvnw test
```

Ou no Windows:
```bash
mvnw.cmd test
```

## 📡 Endpoints da API

### Transações

#### Criar Transação
```http
POST /transactions
Content-Type: application/json

{
  "senderId": 1,
  "receiverId": 2,
  "value": 100.00
}
```

**Resposta de Sucesso (201 Created):**
```json
{
  "id": 1,
  "amount": 100.00,
  "sender": {...},
  "receiver": {...},
  "timestamp": "2024-01-15T10:30:00"
}
```

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

- **Controller**: Recebe as requisições HTTP e retorna as respostas
- **Service**: Contém a lógica de negócio
- **Repository**: Responsável pela persistência de dados
- **Domain**: Entidades do domínio
- **DTOs**: Objetos de transferência de dados

### Fluxo de uma Transação

1. Controller recebe a requisição
2. TransactionService valida o remetente e o saldo
3. AuthorizationService autoriza a transação
4. Saldos são atualizados
5. Transação é salva no banco
6. NotificationService envia notificações
7. Resposta é retornada ao cliente

## 🧪 Testes Implementados

### TransactionServiceTest
- Teste de criação de transação com sucesso
- Teste de validação de saldo insuficiente
- Teste de autorização negada
- Mocks de UserService, AuthorizationService e NotificationService

### UserRepositoryTest
- Testes de persistência de usuários
- Testes de consultas customizadas

## 📚 Aprendizados

Este projeto foi desenvolvido para praticar:

- **Injeção de Dependências** com Spring
- **Testes Unitários** com JUnit 5
- **Mocking** com Mockito
- **Integração com APIs externas** usando RestTemplate
- **Persistência de dados** com JPA/Hibernate
- **Validações de negócio**
- **Tratamento de exceções**

## 🔜 Melhorias Futuras

- [ ] Implementar autenticação e autorização (Spring Security)
- [ ] Adicionar validação de tipos de usuário (comum vs lojista)
- [ ] Implementar rollback de transações em caso de falha
- [ ] Adicionar testes de integração
- [ ] Implementar paginação nos endpoints
- [ ] Adicionar documentação com Swagger/OpenAPI
- [ ] Implementar cache com Redis
- [ ] Adicionar logs estruturados

## 👨‍💻 Autor

Desenvolvido como projeto de estudo para aprimorar conhecimentos em Spring Boot, testes unitários e arquitetura de software.

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais.
