<h1 align="center"> <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/> <img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot"/> <img src="https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white"/> <img src="https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"/> <img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white"/> <img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"/>
</h1>

# <g-emoji class="g-emoji" alias="computer" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/1f4bb.png">💻</g-emoji>Checkpoint Integrador - Clínica Odontológica "Odonto Clean"
## Integrantes | Grupo 3
- Adriana Guedes
- Giovanna Galvão
- Larissa Santos
- Marcelo Pacholak
- Raquel Janine
## Docente
>_Guilherme Lima_
## Mentoria
>_Veronica Braga_
## Disciplina: Back-end do Curso Certified Tech Developer by Digital House Brasil

## Objetivo
***Implementar um sistema que permita administrar a reserva/marcação
de consultas para uma clínica odontológica*** 

>**Administração de dados odontológicos** - Adicionar e modificar os dados
dos dentistas. Registrar nome, sobrenome e matrícula de cadastro

>**Administração de pacientes** - Registrar, modificar e excluir pacientes. De
cada um se armazenam: nome, sobrenome, endereço, RG, data de alta

>**Login** - Validar a entrada no sistema por meio de um login com nome de
usuário e senha. Permitir que qualquer pessoa logada registre uma
consulta, mas apenas aqueles que têm uma função de administração pode
gerenciar dentistas e pacientes

>**Registrar consulta** - Deve ser possível permitir que um paciente seja
atribuído a uma consulta com um dentista em uma determinada data e
hora

### Requerimentos Técnicos:

A aplicação deve ser desenvolvida em camadas:
- [X] **Camada de entidade de negócios** - São as classes Java do nosso negócio
modeladas através do paradigma orientado a objetos.
- [X] **Camada de acesso a dados (Repositório)** - São as classes que se encarregam
de acessar o banco de dados.
- [X] **Camada de dados (banco de dados)** - É o banco de dados do nosso sistema
modelado através de um modelo entidade-relacionamento. Usaremos a
base H2 por sua praticidade.
- [X] **Camada de negócio** - São as classes de serviço que se encarregam de
desacoplar o acesso aos dados da visão.
- [X] **Camada de apresentação** - Estas são as telas da web que teremos que
desenvolver usando o framework Spring Boot MVC com os controladores e
uma dessas duas opções: HTML+JavaScript ou React para a visualização.
- [X] **Tratar as exceções e realizar testes unitários** - Registrar qualquer exceção 
que possa ser gerada e realizando testes unitários para garantir a qualidade dos
desenvolvimentos.

### Aplicação
Criamos uma API para ser consumida por esse sistema, que, conectada á um banco de dados relacional, armazenará os dados dos pacientes, dentistas e consultas. E que contará com um sistema de login para a autenticação dos usuários.

A construção do sistema foi viabilizada através da criação dos itens abaixo:
- [X] Controllers
- [X] Repositories
- [X] Exceptions
- [X] Entities DTO
- [X] Services

### Indicações de uso
- Criar um usuário (Lembre-se que apenas usuários ADMIN podem ter acesso a todas as rotas).
- Atentar-se para não passar o mesmo userName e email para outro usuário. Essa ação não é possível, haja visto que os atributos "userName" e "email" na classe Usuário estão classificados como unicos (Unique = true).
- Autenticar usuário (Criação do token JWT).
- Lembre-se que para criar um Paciente torna-se necessário anteriormente criar um Endereço (O mesmo endereço pode ser atribuído a vários pacientes).
- Atentar-se para não passar o mesmo RG para outro Paciente. Essa ação não é possível, haja visto que o atributo "rg" na classe Paciente está classificada como unica (Unique = true).
- Atentar-se para não passar o mesma Matrícula para outro Dentista. Essa ação não é possível, haja visto que o atributo "matrículaCadastro" na classe Dentista está classificada como unica (Unique = true).
- Para criar uma consulta torna-se necessário um Paciente válido e um Destista válido.



### Tecnologias:

- Java;
- JUnit 5;
- MAVEN;
- Spring Boot;
- H2 Data Base;
- Postman (Para validar toda a interação do sistema com o banco de dados, nos auxiliando á observar a administração da clínica, na prática);

