<h1><b>LogAPI</h1></b>

A LogAPI é uma API de gerenciamento de cadastros de clientes e entregas desenvolvida em Java utilizando o framework Spring. Ela permite realizar operações básicas de CRUD (Create, Read, Update, Delete) para clientes, bem como receber e processar pedidos de entrega associados a esses clientes.

<h2><b>Tecnologias utilizadas</h2></b>

 - Java
 - Spring Framework
 - MySQL
 - Hibernate
 - JPA (Java Persistence API)
 - Lombok
 - Flyway
 - Postman

<h2><b>Pré-requisitos</h2></b>

Antes de executar a API, certifique-se de ter as seguintes ferramentas instaladas em seu ambiente de desenvolvimento:

 - Java Development Kit (JDK) versão 8 ou superior
 - Maven (para gerenciamento de dependências)
 - MySQL Server (ou outro banco de dados compatível)
 - Postman (opcional, utilizado para testar as funcionalidades da API)

<h1><b>Configuração do banco de dados</h1></b>

1. Crie um banco de dados MySQL para a API. Você pode usar a seguinte linha de comando no terminal do MySQL para criar o banco de dados:

~~~sql
CREATE DATABASE logapi;
~~~

2. Atualize as informações de configuração do banco de dados no arquivo `application.properties`, localizado em `src/main/resources`. Substitua as informações entre colchetes pelos valores correspondentes ao seu ambiente:

~~~properties
spring.datasource.url=jdbc:mysql://[seu_host]:[sua_porta]/logapi?useSSL=false
spring.datasource.username=[seu_usuario]
spring.datasource.password=[sua_senha]

spring.flyway.baseline-on-migrate=true

spring.jpa.show-sql=true

debug=true
~~~

<h2><b>Configuração do banco de dados com JPA e Flyway</h2></b>

A LogAPI utiliza o JPA (Java Persistence API) em conjunto com o Flyway para criar e migrar o esquema do banco de dados.

<h2><b>Criação do banco de dados</h2></b>

Certifique-se de ter criado o banco de dados "logapi" no seu servidor MySQL conforme mencionado anteriormente.

<h2><b>Script SQL de criação das tabelas</h2></b>

O JPA é responsável por criar as tabelas no banco de dados com base nas entidades definidas no código. Abaixo está o script SQL que representa a criação das tabelas "cliente" e "entrega":

~~~sql
CREATE TABLE cliente (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE entrega(
    id BIGINT NOT NULL AUTO_INCREMENT,
    cliente_id BIGINT NOT NULL,
    taxa DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    data_pedido DATETIME NOT NULL,
    data_finalizacao DATETIME,
    
    destinatario_nome VARCHAR(60) NOT NULL,
    destinatario_logradouro VARCHAR(255) NOT NULL,
    destinatario_numero VARCHAR(30) NOT NULL,
    destinatario_complemento VARCHAR(60) NOT NULL,
    destinatario_bairro VARCHAR(30) NOT NULL,

    PRIMARY KEY (id)
);

ALTER TABLE entrega ADD CONSTRAINT fk_entrega_cliente
FOREIGN KEY (cliente_id) REFERENCES cliente (id);
~~~

Essas tabelas serão criadas automaticamente quando a aplicação LogAPI for executada pela primeira vez.

<h1><b>Executando a API</h1></b>

1. Clone este repositório para o seu ambiente local.
2. Abra o projeto em sua IDE Java preferida.
3. Importe as dependências Maven.
4. Execute o arquivo `LogApiApplication.java`, localizado em `src/main/java/com/yourpackage/logapi`.
5. A API será iniciada e estará disponível em http://localhost:8080.


<h1><b>Testando as funcionalidades da API</h1></b>

Você pode utilizar o Postman para testar as funcionalidades da API. A seguir, são descritos os endpoints disponíveis:

<h2><b>Clientes</h2></b>

`GET /clientes`: Retorna uma lista de todos os clientes cadastrados.

`GET /clientes/{id}`: Retorna os detalhes de um cliente específico com base no ID fornecido.

`POST /clientes`: Adiciona um novo cliente à base de dados. Certifique-se de fornecer as informações do cliente no corpo da requisição.

`PUT /clientes/{id}`: Atualiza as informações de um cliente existente com base no ID fornecido. Certifique-se de fornecer as informações atualizadas do cliente no corpo da requisição.

`DELETE /clientes/{id}`: Deleta um cliente existente com base no ID fornecido.

<h2><b>Entregas</h2></b>

`POST /entregas`: Cria uma nova ordem de entrega. Certifique-se de fornecer as informações da entrega no corpo da requisição, incluindo o local de entrega e o ID do cliente associado à entrega.

Certifique-se de substituir `{id}` pelos valores correspondentes ao cliente específico que você deseja consultar, atualizar ou excluir.

Contribuição
Fique à vontade para contribuir para o desenvolvimento deste projeto. Se você encontrar algum problema ou tiver alguma sugestão, abra uma nova issue ou envie um pull request.

Licença
Este projeto está licenciado sob a licença MIT.

Configuração do banco de dados com JPA e Flyway
A LogAPI utiliza o JPA (Java Persistence API) em conjunto com o Flyway para criar e migrar o esquema do banco de dados.

Criação do banco de dados
Certifique-se de ter criado o banco de dados "logapi" no seu servidor MySQL conforme mencionado anteriormente.

Script SQL de criação das tabelas
O JPA é responsável por criar as tabelas no banco de dados com base nas entidades definidas no código. Abaixo está o script SQL que representa a criação das tabelas "cliente" e "entrega":

sql
Copy code
CREATE TABLE cliente (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE entrega(
    id BIGINT NOT NULL AUTO_INCREMENT,
    cliente_id BIGINT NOT NULL,
    taxa DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    data_pedido DATETIME NOT NULL,
    data_finalizacao DATETIME,
    
    destinatario_nome VARCHAR(60) NOT NULL,
    destinatario_logradouro VARCHAR(255) NOT NULL,
    destinatario_numero VARCHAR(30) NOT NULL,
    destinatario_complemento VARCHAR(60) NOT NULL,
    destinatario_bairro VARCHAR(30) NOT NULL,

    PRIMARY KEY (id)
);

ALTER TABLE entrega ADD CONSTRAINT fk_entrega_cliente
FOREIGN KEY (cliente_id) REFERENCES cliente (id);
Essas tabelas serão criadas automaticamente quando a aplicação LogAPI for executada pela primeira vez.

Migração de banco de dados com o Flyway
O Flyway é uma ferramenta de migração de banco de dados que permite evoluir o esquema do banco de dados de forma controlada. A configuração do Flyway já está incluída no projeto LogAPI.

Os scripts SQL de migração devem ser colocados no diretório src/main/resources/db/migration. Cada script de migração deve ter um nome único, começando com um prefixo que indica a versão do script, seguido por um descritor.

Por exemplo, o nome do script de migração inicial pode ser V1__create_tables.sql. O prefixo "V1" indica que é a primeira versão do script.

Ao iniciar a aplicação, o Flyway verificará automaticamente os scripts de migração no diretório especificado e aplicará as alterações necessárias para atualizar o esquema do banco de dados.