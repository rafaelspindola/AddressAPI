# Address API

Este projeto Spring Boot foi desenvolvido para fornecer uma API simples para gerenciar pessoas e seus endereços associados. Ele permite criar, editar e recuperar informações sobre pessoas e seus endereços.

- [Iniciando](#iniciando)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Endpoints](#endpoints)
- [Testes](#testes)
- [AWS](#aws)

## Iniciando

Para começar com este projeto, siga estas etapas:

**Clone o repositório:**

   ```shell
   git clone https://github.com/rafaelspindola/AddressAPI.git)https://github.com/rafaelspindola/AddressAPI.git
   ```
**Construa e execute a aplicação:**
Você pode usar sua IDE favorita ou os seguintes comandos:

```shell
cd AddressAPI
./mvnw spring-boot:run
```

**Acesse a API:**
A API estará disponível em http://localhost:8080. Você pode usar ferramentas como o Postman ou o curl para interagir com ela.

## Estrutura do Projeto

A estrutura do projeto está organizada da seguinte forma:

   - src/main/java: Arquivos de código-fonte Java.
       - com.attornatus.addressapi: Pacote principal da aplicação.
          -  controller: Contém classes de controlador que lidam com requisições HTTP.
          -  service: Contém classes de serviço para a lógica de negócios.
          -  model: Contém modelos de dados ou classes de entidade.
          -  repository: Contém repositórios Spring Data JPA para interação com o banco de dados.
           
   - src/main/resources: Arquivos de configuração e recursos.
       - application.properties: Arquivo de propriedades da aplicação.
       - static: Recursos estáticos (por exemplo, HTML, CSS, JavaScript).
       - templates: Templates Thymeleaf (se estiver usando Thymeleaf).
     
   - src/test: Arquivos de código-fonte de teste.
       - com.attornatus.addressapi: Classes de teste para testes unitários e de integração.
    
## Endpoints
Esta API fornece os seguintes endpoints:

    GET /api/v1/pessoas/{id}: Busque uma pessoa pelo ID.
    POST /api/v1/pessoas: Crie uma nova pessoa.
    GET /api/v1/pessoas: Liste todas as pessoas.
    PUT /api/v1/pessoas/{id}: Edite uma pessoa existente.
    POST /api/v1/pessoas/{pessoaId}/enderecos: Crie um novo endereço para uma pessoa.
    GET /api/v1/pessoas/{pessoaId}/enderecos: Liste todos os endereços associados a uma pessoa.
    POST /api/v1/pessoas/{pessoaId}/enderecos/{enderecoId}/principal: Defina um endereço como principal para uma pessoa.

## Testes

Este projeto inclui testes para garantir a qualidade e a confiabilidade do código. 
Os testes unitários são usados para testar unidades individuais de código, como classes de serviço e controladores. Eles são armazenados no diretório src/test/java.
Para executar os testes unitários, use o seguinte comando:

```
./mvnw test
```

## AWS
Foi feito o deploy na AWS Elastic Beanstalk. O link para acesso à API é:
```
http://attornatus-h2-env.eba-s6c2yxqe.sa-east-1.elasticbeanstalk.com
```
Uma vez acessada, é possível testar todos os endpoints supracitados para verificar o funcionamento da API.
