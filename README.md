# Avaliação de Arquitetura de Sistemas

## WegOffice
Aplicação Spring Boot para gerenciamento de classes, alunos, professores e ordens de serviço.

#### Professor: [Lucas Sousa dos Santos](https://github.com/engineer-lucas)
#### UC: Arquitetura de Sistemas
#### Aluno: [Kauã Felix da Silva Costa](https://github.com/kauaafeelix)
#### Turma: MIDS 78

### Tecnologias Utilizadas
- Java 21
- Spring Boot 3.5.13
- Spring Data JPA
- Spring Web
- Spring Validation
- Spring DevTools
- MySQL - Banco de dados
- Lombok - Redução de boilerplate
- Maven - Gerenciador de dependências

### Funcionalidades
- CRUD de _Classes_, _Alunos_, _Professores_ e _Ordens de Serviço_
- Validação de dados de entrada
- Relacionamento entre entidades (Classes, Alunos, Professores e Ordens de Serviço)
- Cardinalidades entre as entidades (*Many-to-One, One-to-Many, Many-to-Many*)
- Criação da tabela de relacionamento entre _Alunos_ e _Ordens de Serviço_ para representar a relação de muitos para muitos
- Configuração de banco de dados **MySQL**
- Endpoints **REST** para cada entidade
- Utilização de **DTOs** para transferência de dados
- Docker para conteinerização do banco de dados **MySQL**
