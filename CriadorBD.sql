CREATE DATABASE produtos_bd;
USE produtos_bd;

DROP TABLE IF EXISTS PRODUTOS;

CREATE TABLE PRODUTOS(
                         PRODUTOS_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                         NOME VARCHAR(225),
                         DESCRICAO VARCHAR(1024),
                         MARCA VARCHAR(225),
                         CATEGORIA VARCHAR(225),
                         PRECO DECIMAL(20,2),
                         CUSTO DECIMAL(20,2)
);

INSERT INTO PRODUTOS (NOME, DESCRICAO, MARCA, CATEGORIA, PRECO, CUSTO)
VALUES ('Camiseta Radiohead', '', 'Republic Record', 'Camiseta', 25, 10);

INSERT INTO PRODUTOS (NOME, DESCRICAO, MARCA, CATEGORIA, PRECO, CUSTO)
VALUES ('Hollywoods Bleending', 'Album de Post Malone', 'Republic Record', 'Album', 50, 28);

INSERT INTO PRODUTOS (NOME, DESCRICAO, MARCA, CATEGORIA, PRECO, CUSTO)
VALUES ('Live in London', 'Album de Jorge e Mateus', 'Som Livre', 'Album', '500', '300');

CREATE USER 'Adm'@'localhost' IDENTIFIED BY 'Secret_123';
GRANT ALL PRIVILEGES ON produtos_bd.* TO 'Adm'@'localhost';