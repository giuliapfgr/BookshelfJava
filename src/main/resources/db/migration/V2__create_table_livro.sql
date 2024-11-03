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


INSERT INTO livro (id_do_livro, nome, genero, paginas, autor, editora, data_de_publicacao, capa)
VALUES (1, 'O Senhor dos Anéis: A Sociedade do Anel', 'Fantasia, Aventura', 576, 'J. R. R. Tolkien', 'HarperCollins', 1954, 'imagem da capa');
