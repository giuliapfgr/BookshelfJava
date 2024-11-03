CREATE TABLE usuario(
     id_do_usuario INT PRIMARY KEY,
     nome VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL,
     idade INT NOT NULL,
     id_do_livro INT NOT NULL,
     FOREIGN KEY (id_do_livro) REFERENCES livro(id_do_livro)
);

    INSERT INTO usuario (id_do_usuario, nome, email, idade, id_do_livro)
    VALUES (1, 'João Silva', 'joao.silva@example.com', 30, 1);
