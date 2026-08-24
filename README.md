# CP4.2

API REST em Spring Boot para cadastro e consulta de carros e marcas, com persistência em MySQL.

## O que este projeto faz

- expõe endpoints de CRUD para carros e marcas
- salva os dados no MySQL
- usa Swagger/OpenAPI para documentação e testes
- suporta execução via Docker

---

## Requisitos

- Docker
- Docker Desktop ou Docker Engine funcionando
- MySQL rodando em container

---

## 1) Subir o MySQL

Execute este comando para subir o banco em container:

```bash
docker run -d \
  --name mysql \
  --rm \
  -e MYSQL_ROOT_PASSWORD=root_pwd \
  -e MYSQL_USER=new_user \
  -e MYSQL_PASSWORD=my_pwd \
  -p 3306:3306 \
  mysql
```

Esse comando cria o MySQL e expõe a porta `3306`.

> O banco `dbdev` pode ser criado automaticamente pela aplicação, conforme a configuração do datasource.

---

## 2) Build da imagem da aplicação

Na raiz do projeto:

```bash
docker build -t cp4.2:1.1 .
```

---

## 3) Variáveis de ambiente

No Windows PowerShell, defina:

```powershell
$env:DB_SERVER_URL="localhost"
$env:DB_SERVER_PORT="3306"
$env:DB_SCHEMA="dbprd"
$env:DB_USER="root"
$env:DB_PWD="root_pwd"
$env:SPRING_PROFILES_ACTIVE="dev"
```

Essas variáveis são usadas pela aplicação para conectar ao MySQL e selecionar o profile ativo.

---

## 4) Rodar a aplicação em Docker

```bash
docker run \
  -p 8080:8080 \
  -e DB_SERVER_URL=host.docker.internal \
  -e DB_SERVER_PORT=3306 \
  -e DB_SCHEMA=dbdev \
  -e DB_USER=root \
  -e DB_PWD=root_pwd \
  -e SPRING_PROFILES_ACTIVE=dev \
  cp4.2:1.1
```

### Observações

- `host.docker.internal` é usado para acessar o MySQL que está rodando na máquina host
- `SPRING_PROFILES_ACTIVE=dev` ativa o profile de desenvolvimento
- `DB_SCHEMA=dbdev` é o schema que a aplicação vai utilizar

---

## ⚙️ Profiles do Spring Boot

O profile ativo da aplicação é definido através da variável de ambiente:

```bash
SPRING_PROFILES_ACTIVE
```

### Desenvolvimento

Para executar utilizando o profile `dev`:

```bash
export SPRING_PROFILES_ACTIVE=dev
```

### Produção

Para executar utilizando o profile `prd`:

```bash
export SPRING_PROFILES_ACTIVE=prd
```

Ao executar com Docker:

```bash
docker run \
  -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prd \
  study-api:1.1
```

---

## 5) Acesso

### Swagger/OpenAPI

```text
http://localhost:8080/
```

### API

```text
http://localhost:8080/api/v1/carros
http://localhost:8080/api/v1/marcas
```

---

## 6) Endpoints principais

### Carros

```text
GET    /api/v1/carros
GET    /api/v1/carros/{id}
POST   /api/v1/carros
PUT    /api/v1/carros/{id}
DELETE /api/v1/carros/{id}
```

### Marcas

```text
GET    /api/v1/marcas
GET    /api/v1/marcas/{id}
POST   /api/v1/marcas
PUT    /api/v1/marcas/{id}
DELETE /api/v1/marcas/{id}
```

---

## 7) Importante

- a aplicação depende do banco MySQL estar disponível antes de subir
- o projeto usa o profile `dev`
- o Docker daemon precisa estar em execução
- em caso de erro de conexão, verifique o MySQL e as variáveis de ambiente

---

## Integrantes

- Lucas Salles RM554789