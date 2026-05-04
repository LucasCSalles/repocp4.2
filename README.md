Projeto API Spring Boot
Descrição

API desenvolvida com Spring Boot para gerenciamento de dados.
Este projeto utiliza banco de dados MySQL rodando em container Docker.

Tecnologias utilizadas
Java
Spring Boot
Maven
Docker
MySQL

Pré-requisitos

Antes de começar, você precisa ter instalado:

Java 17+
Maven
Docker

Abrir o docker (Start docker service) E subir o banco de dados docker

Subindo o banco de dados com Docker

Execute o comando abaixo para iniciar o MySQL:

docker run -d \
  --name mysql \
  --rm \
  -e MYSQL_ROOT_PASSWORD=root_pwd \
  -e MYSQL_USER=new_user \
  -e MYSQL_PASSWORD=my_pwd \
  -e MYSQL_DATABASE=my_db \
  -p 3306:3306 \
  mysql:8

🔧 Configuração da aplicação

No arquivo application.properties configure:

spring.datasource.url=jdbc:mysql://localhost:3306/my_db
spring.datasource.username=root
spring.datasource.password=root_pwd
spring.jpa.hibernate.ddl-auto=update

Observações:

Porta: 3306
Banco criado: my_db
Usuário: root
Senha: root_pwd
(Pode ser alterado pelo application.properties)


Rodando a aplicação

Na raiz do projeto, execute:

mvn spring-boot:run

Testando a API

Após subir a aplicação, ela estará disponível em:

http://localhost:8080

Para parar o banco:

docker stop mysql
Observações finais
Certifique-se de que a porta 3306 não está sendo usada.
Aguarde alguns segundos após subir o container para o MySQL inicializar completamente.