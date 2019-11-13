# helloworld-cicd

Projeto de exemplo de integração contínua e entrega contínua usando

* CircleCI - Motor da Integração e Entrega Contínua - [![CircleCI](https://circleci.com/gh/rcvieira/helloworld-cicd.svg?style=svg)](https://circleci.com/gh/rcvieira/helloworld-cicd)
* SonarCloud - Análise do Estática do Código
* Heroku - Ambiente de Homologação

## Desenvolvimento

Este projeto utiliza as seguintes tecnologias:
* Java 8
* Maven 3
* Docker
* PostgreSQL 11

### Banco de Dados

O banco de dados de desenvolvimento pode ser iniciado com o comando:

```
./database/start-postgres.sh
```

O cliente psql é iniciado com o comando:

```
./database/start-postgres-client.sh
```

E o banco de dados pode ser parado com o comando:

```
./database/stop-postgres.sh
```