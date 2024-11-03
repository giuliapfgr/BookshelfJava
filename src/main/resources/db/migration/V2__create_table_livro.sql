CREATE TABLE livro (
    id_do_livro INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    genero VARCHAR(255) NOT NULL,
    paginas INT NOT NULL,
    autor VARCHAR(255) NOT NULL,
    editora VARCHAR(255) NOT NULL,
    data_de_publicacao INT NOT NULL,
    capa VARCHAR(255)
);

CREATE SEQUENCE livro_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE usuario(
    id_do_usuario INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    id_do_livro INT NOT NULL,
    FOREIGN KEY (id_do_livro) REFERENCES livro(id_do_livro)
);

CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;
