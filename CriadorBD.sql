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
VALUES ('Camiseta Radiohead', 'Camiseta preta com a cor do álbum', 'Hering', 'Camiseta', 25, 10);

INSERT INTO PRODUTOS (NOME, DESCRICAO, MARCA, CATEGORIA, PRECO, CUSTO)
VALUES ('CD Wilco', 'Album de Ghost is born', 'Virgin Records', 'CD', 15.5,  8);

INSERT INTO PRODUTOS (NOME, DESCRICAO, MARCA, CATEGORIA, PRECO, CUSTO)
VALUES ('CD Hollywoods Bleending', 'Album de Post Malone', 'Republic Record', 'CD', 50, 28);

INSERT INTO PRODUTOS (NOME, DESCRICAO, MARCA, CATEGORIA, PRECO, CUSTO)
VALUES ('CD Live in London', 'Album de Jorge e Mateus', 'Som Livre', 'CD', 50, 19);

INSERT INTO PRODUTOS (NOME, DESCRICAO, MARCA, CATEGORIA, PRECO, CUSTO)
VALUES ('Blu-ray Metallica', 'Album  Orquestra Sinfônica de San Francisco', 'Blackened Recordings', 'Blu-ray', 59.99, 35);

INSERT INTO PRODUTOS (NOME, DESCRICAO, MARCA, CATEGORIA, PRECO, CUSTO)
VALUES ('Fone de Ouvido Bluetooth', 'Fone de ouvido sem fio', 'Sony', 'Acessório', 199.9, 120);



CREATE USER 'Adm'@'localhost' IDENTIFIED BY 'Secret_123';
GRANT ALL PRIVILEGES ON produtos_bd.* TO 'Adm'@'localhost';