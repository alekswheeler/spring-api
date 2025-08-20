# spring-api

Uma API REST usando Java e Spring Boot para operações CRUD de estudantes, seguindo o tutorial do [Amigoscode](https://www.youtube.com/c/amigoscode).

## 📋 Funcionalidades

- ✅ **CRUD Completo de Estudantes**
  - Criar novo estudante
  - Listar todos os estudantes
  - Buscar estudante por ID
  - Atualizar dados do estudante
  - Deletar estudante

- ✅ **Cálculo Automático de Idade**
  - Idade calculada dinamicamente a partir da data de nascimento
  - Campo `age` não é persistido no banco (usando `@Transient`)

- ✅ **Banco de Dados PostgreSQL**
  - Integração com PostgreSQL usando JPA/Hibernate
  - Configuração de sequência para geração de IDs

## 🛠️ Tecnologias Utilizadas

- **Java 24**
- **Spring Boot 3.5.4**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**

## 📁 Estrutura do Projeto

```
src/main/java/com/example/demo/
├── Student/
│   ├── Student.java          # Entidade JPA
│   ├── StudentController.java # Controller REST
│   ├── StudentService.java    # Lógica de negócio
│   └── StudentRepository.java # Interface de acesso aos dados
├── DemoApplication.java       # Classe principal
└── resources/
    └── application.properties # Configurações da aplicação
```

## ⚙️ Configuração e Execução

### Pré-requisitos
- Java 24+ instalado
- PostgreSQL instalado e rodando
- Maven instalado

### 1. Clone o repositório
```bash
git clone <url-do-repositorio>
cd spring-api
```

### 2. Configure o banco de dados
Crie um banco PostgreSQL chamado `student` e configure o `application.properties`:

```properties
# Configuração do banco PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/student
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA_AQUI
spring.datasource.driver-class-name=org.postgresql.Driver

# Configurações do Hibernate/JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

### 3. Execute a aplicação
```bash
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

## 🔗 Endpoints da API

### Estudantes

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/v1/student` | Lista todos os estudantes |
| GET | `/api/v1/student/{id}` | Busca um estudante por ID |
| POST | `/api/v1/student` | Cria um novo estudante |
| PUT | `/api/v1/student/{id}` | Atualiza um estudante |
| DELETE | `/api/v1/student/{id}` | Remove um estudante |

### Exemplos de Uso

#### Criar um novo estudante (POST)
```bash
curl -X POST http://localhost:8080/api/v1/student \
  -H "Content-Type: application/json" \
  -d '{
    "name": "João Silva",
    "email": "joao@email.com",
    "dateOfBirthday": "1995-05-15"
  }'
```

#### PowerShell
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/v1/student" -Method POST -Headers @{"Content-Type"="application/json"} -Body '{"name":"João Silva","email":"joao@email.com","dateOfBirthday":"1995-05-15"}'
```

#### Listar todos os estudantes (GET)
```bash
curl http://localhost:8080/api/v1/student
```

#### Atualizar um estudante (PUT)
```bash
curl -X PUT http://localhost:8080/api/v1/student/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "João Santos",
    "email": "joao.santos@email.com",
    "dateOfBirthday": "1995-05-15"
  }'
```

## 📊 Modelo de Dados

### Entidade Student
```java
{
  "id": 1,
  "name": "João Silva",
  "email": "joao@email.com",
  "age": 28,                    // Calculado automaticamente
  "dateOfBirthday": "1995-05-15"
}
```

**Observações:**
- `id`: Gerado automaticamente pela sequência PostgreSQL
- `age`: Campo calculado dinamicamente, não persistido no banco
- `dateOfBirthday`: Usado para calcular a idade atual

## 🚀 Melhorias Futuras

### 🐳 Docker
- [ ] Containerização da aplicação
- [ ] Docker Compose com PostgreSQL

### 🔐 Segurança
- [ ] Implementação de autenticação JW
- [ ] Validação de entrada de dados

### 🧪 Testes
- [ ] Testes unitários com JUnit 5
- [ ] Testes de integração
- [ ] Testes de API com TestContainers

### 📈 Observabilidade
- [ ] Logging estruturado
- [ ] Métricas com Actuator
- [ ] Health checks

### 🔧 Outras Melhorias
- [ ] Paginação nos endpoints de listagem
- [ ] Tratamento global de exceções
- [ ] Documentação com Swagger/OpenAPI
- [ ] Profiles para diferentes ambientes
- [ ] Cache com Redis

## 🤝 Contribuindo

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 📚 Referências

- [Tutorial Amigoscode](https://www.youtube.com/c/amigoscode)
- [Documentação Spring Boot](https://spring.io/projects/spring-boot)
- [Documentação Spring Data JPA](https://spring.io/projects/spring-data-jpa)

## 👨‍💻 Autor

Desenvolvido como projeto de estudo seguindo o tutorial do Amigoscode.

---

⭐ Se este projeto te ajudou, considere dar uma estrela!