# crud-basic-client
 
CRUD completo de services REST para acessar um recurso de clientes, contendo as cinco operações básicas:
1) Busca paginada de recursos.
2) Busca de recurso por id.
3) Inserir novo recurso.
4) Atualizar recurso.
5) Deletar recurso.

# Como executar o projeto
## Back-end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/pcoliveira90/crud-basic-client

# entrar na pasta do projeto back end
cd crud-basic-client

# executar o projeto
./mvnw spring-boot:run
```
## Como consumir o projeto
Pré-requisitos: Postman 

Importar api : https://github.com/pcoliveira90/crud-basic-client/blob/main/postman/Crud%20basic%20client.postman_collection.json

![Operações](https://github.com/pcoliveira90/crud-basic-client/blob/main/img/servi%C3%A7os.png)

Selecionar operação e enviar (send) para testar.

### Get all
![Get ALL](https://github.com/pcoliveira90/crud-basic-client/blob/main/img/get_findAll.png)

### Get id
![Get ID](https://github.com/pcoliveira90/crud-basic-client/blob/main/img/get_findById.png)

### Post
![POST](https://github.com/pcoliveira90/crud-basic-client/blob/main/img/post.png)

### Put
![PUT](https://github.com/pcoliveira90/crud-basic-client/blob/main/img/put.png)

### Delete
![DELETE](https://github.com/pcoliveira90/crud-basic-client/blob/main/img/delete.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven

# Autor

Paula Cristina de Oliveira

https://www.linkedin.com/in/paula-cristina-oliveira-19746513/
