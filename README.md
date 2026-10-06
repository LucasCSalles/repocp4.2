CP5

API REST em Spring Boot para cadastro e consulta de carros e marcas, utilizando SQL Server para persistência dos dados.

O que o projeto faz

Cadastro, consulta, atualização e exclusão de carros.

Cadastro, consulta, atualização e exclusão de marcas.

Persistência dos dados em SQL Server.

Documentação e testes da API através do Swagger/OpenAPI.

Requisitos

Java

Docker

Docker em execução

1. Subir o SQL Server

Execute no terminal:

docker run -d \
  --name sqlserver \
  --rm \
  -e MSSQL_SA_PASSWORD=1q2w3e4R@ \
  -e "ACCEPT_EULA=Y" \
  -p 1433:1433 \
  mcr.microsoft.com/mssql/server:latest


O SQL Server ficará disponível na porta 1433.

As credenciais utilizadas são:

Usuário: sa
Senha: 1q2w3e4R@
Porta: 1433

2. Rodar o projeto

Com o SQL Server em execução, abra o PowerShell na raiz do projeto e execute:

.\mvnw spring-boot:run "-Dspring-boot.run.profiles=dev"


Esse comando inicia a aplicação Spring Boot utilizando o profile dev.

Não é necessário executar a aplicação utilizando Docker.

3. Acesso

Após a aplicação iniciar, ela estará disponível em:

http://localhost:8080

Swagger/OpenAPI
http://localhost:8080/

API

Carros:

http://localhost:8080/api/v1/carros


Marcas:

http://localhost:8080/api/v1/marcas

4. Endpoints principais
Carros
GET    /api/v1/carros
GET    /api/v1/carros/{id}
POST   /api/v1/carros
PUT    /api/v1/carros/{id}
DELETE /api/v1/carros/{id}

Marcas
GET    /api/v1/marcas
GET    /api/v1/marcas/{id}
POST   /api/v1/marcas
PUT    /api/v1/marcas/{id}
DELETE /api/v1/marcas/{id}

5. Ordem para executar

Sempre siga esta ordem:

1. Subir o SQL Server
docker run -d \
  --name sqlserver \
  --rm \
  -e MSSQL_SA_PASSWORD=1q2w3e4R@ \
  -e "ACCEPT_EULA=Y" \
  -p 1433:1433 \
  mcr.microsoft.com/mssql/server:latest

2. Rodar o projeto

No PowerShell, na raiz do projeto:

.\mvnw spring-boot:run "-Dspring-boot.run.profiles=dev"

3. Acessar
http://localhost:8080

Integrante

Lucas Salles RM554789