# Bookshelf

**API Rest do projeto Bookshelf - Estante de livros virtual**\
\
_**Grupo:** Giulia Pina e Luiz Felipe Biazzola_ 

## Requisitos

- [ ] CRUD de Usuários
- [ ] Autenticação
- [ ] CRUD de Livros
- [ ] Dashboard
- [ ] Reviews

## Documentação

### Endpoints

- [Listar Livros](#listar-livros)
- [Cadastrar Livros](#cadastrar-livros)
- [Apagar livro](#apagar-livro)
- [Detalhar livros](#detalhar-livro)
- [Atualizar livros](#atualizar-livro)


### Listar Livros

`GET` /livro

Retorna um array com todos os livros cadastrados pelo usuário atual.

#### Exemplo de Resposta

```js

{
    "id do livro": 1,
    "nome": "O Senhor dos Anéis: A Sociedade do Anel",
    "gênero": "Fantasia", "Aventura",
    "páginas": 576,
    "autor": "J. R. R. Tolkien",
    "editora": "HarperCollins",
    "data de publicação": 1954,
    "capa": "imagem da capa"
}

```


#### Códigos de Resposta

| código | descrição |
|--------|-----------|
|200| Livros retornados com sucesso
|401| Não autorizado. Realize a autenticação em /login

---

### Cadastrar livros

`POST` /livro

Cadastra um livro com os dados enviados no corpo da requisição.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|--------
|nome|string|✅| Nome do livro
|gênero|string|✅| Gênero do livro
|páginas|int|✅| Total de páginas
|autor|string|✅|Autor do livro
|editora|string|❌|Editora atual
|publicação|int|✅|Data de primeira publicação
|capa|img|❌|Imagem de capa

```js

{
    "nome": "O Senhor dos Anéis: A Sociedade do Anel",
    "gênero": "Fantasia", "Aventura",
    "páginas": 576,
    "autor": "J. R. R. Tolkien",
    "editora": "HarperCollins",
    "data de publicação": 1954,
    "capa": "imagem da capa"
}

```

#### Exemplo de Resposta

```js
[
    {
        "id": 1,
        "nome": "O Senhor dos Anéis: A Sociedade do Anel",
        "gênero": "Fantasia", "Aventura",
        "páginas": 576,
        "autor": "J. R. R. Tolkien",
        "editora": "HarperCollins",
        "data de publicação": 1954,
        "capa": "imagem da capa"
    }
]
```

#### Código de Resposta

| código | descrição |
|--------|-----------|
|201| Livro cadastrado com sucesso
|400| Validação falhou. Verifique os dados enviados no corpo da requisição
|401| Não autorizado. Realize a autenticação em /login

---

### Apagar Livro

`DELETE` /livro/`{id}`

Apaga a categoria com o `id` informado no parâmetro de path.

#### Código de Resposta

| código | descrição |
|--------|-----------|
|204| Livro apagado com sucesso
|401| Não autorizado. Realize a autenticação em /login

---

### Detalhar livro

`GET` /livro/`{id}`

Retorna os dados do livro com o `id` informado no parâmetro de path.


#### Exemplo de Resposta

```js
// requisição /livro/2

{
"id": 2,
"nome": "Orgulho e Preconceito"
"gênero": "Drama", "Romance",
"páginas": 424,
"autor": "Jane Austen",
"editora": "Martin Claret",
"data de publicação": 1813,
"capa": "imagem da capa"
}

```


#### Código de Resposta

| código | descrição |
|--------|-----------|
|200| Livro retornado com sucesso
|401| Não autorizado. Realize a autenticação em /login
|404| Não existe livro com o `id` informado

---

### Atualizar Livro

`PUT` /livro/`{id}`

Atualiza os dados do livro com o `id` informado no path


#### Corpo da Requisição

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|--------
|nome|string|✅| Nome do livro
|gênero|string|✅| Gênero do livro
|páginas|int|✅| Total de páginas
|autor|string|✅|Autor do livro
|editora|string|❌|Editora atual
|publicação|int|✅|Data de primeira publicação
|capa|img|❌|Imagem de capa

```js
{
"nome": "Orgulho e Preconceito"
"gênero": "Drama", "Romance",
"páginas": 424,
"autor": "Jane Austen",
"editora": "Martin Claret",
"data de publicação": 1813,
"capa": "imagem da capa"
}
```



#### Exemplo de Resposta

```js
{
"id": 2,
"nome": "Orgulho e Preconceito"
"gênero": "Drama", "Romance",
"páginas": 424,
"autor": "Jane Austen",
"editora": "Martin Claret",
"data de publicação": 1813,
"capa": "imagem da capa"
}
```




#### Código de Resposta

| código | descrição |
|--------|-----------|
|200| Livro cadastrado com sucesso
|400| Validação falhou. Verifique os dados enviados no corpo da requisição
|401| Não autorizado. Realize a autenticação em /login
|404| Não existe livro com o `id` informado

---
