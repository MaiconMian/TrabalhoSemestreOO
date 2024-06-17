## Trabalho Prático de Orientação á Objetos
Criação de um controle de produtos para Blue Velvet Music Story, podendo adicionar, remover, e modificar produtos de um banco de dados

# Dependências

As únicas dependencias que você precisa se preocupar é ter o maven e o MySql instalados.

O arquivo CriadorBD.sql irá gerar o banco de dados e o configurar, se estiver no linux, basta execurtar:

```sh
    mysql -u root -p < CriadorBD.sql
``` 

Pronto, o banco de dados está funcionando.

# Iniciando

Se o banco de dados foi criado corretamente, para iniciar o programa, basta rodar o comando na pasta com pom.xml:

```sh
    mvn javafx:run
``` 

Pronto, agora o controle de Produtos está funcionando.

