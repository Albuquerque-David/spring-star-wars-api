# spring-star-wars-api

![alt text](star_wars_logo.png)

## Sobre

Spring Star Wars API é uma API Java desenvolvida para armazenar e disponibilizar os dados de planetas do universo de Star Wars. Seus dados são inseridos manualmente, clonados de acordo com o id a partir da API encontrada em https://swapi.dev/about. Os planetas já disponíveis na Swapi são inseridos automáticamente via Migration ao subir a aplicação.

## Tecnologias Utilizadas

```
Java 11
MongoDB
Docker
Maven
JUnit5
Spring Boot
Spring Data MongoDB
Mongock
Swagger2
``` 

## Pré-Requisitos

Requisitos necessários para rodar a aplicação.

```
Maven
Docker
Docker Compose
```

## Instalação

```
git clone https://github.com/albuquerque-david/spring-star-wars-api
```

Entre na pasta clonada

```
mvn clean install -DskipTests
```

Isto irá gerar o build da aplicação ( Os testes unitários e de integração podem ser executados via IDE (Eclipse/Intellij) ) para que possamos gerar a imagem Docker a ser utilizada.

```
docker build -t star-wars-api-image .
docker-compose up
```

Com isto, após alguns instantes, a aplicação será inicializada. 

## Uso

A spring-star-wars-api estará disponível para uso na porta 8080, sem a necessidade de autenticação, podendo receber requisições de qualquer cliente.

Há disponível também na porta 8080 o endereço 8080/swagger-ui.html, com a documentação da API e seus endpoints que podem ser utilizados.

## Problemas encontrados

Existem 2 problemas ainda mapeados na utilização da API.

Os testes unitários e de integração estão com inconsistências em seus builds, sendo possível realizar estes testes somente utilizando IDE ( Eclipse/Intellij ), pois o mesmo utiliza de um servidor em memória para realizar os testes. Desta forma, a flag -DskipTests está sendo utilizada durante o build para gerar de forma consistente.

Outro problema encontrado é durante a utilização do Docker. Pode ser necessário permissão de administrador/sudo para execução dos comandos.



