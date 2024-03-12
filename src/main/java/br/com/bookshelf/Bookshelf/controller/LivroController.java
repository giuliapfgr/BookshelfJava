package br.com.bookshelf.Bookshelf.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.bookshelf.Bookshelf.model.Livro;
import br.com.bookshelf.Bookshelf.repository.LivroRepository;

@RestController //Anotação para informar que a classe é um controller e que os metodos tratam solicitações HTTP
@RequestMapping("livro")//Anotação para mapear todas as solicitações feitas para a url /livro exemplo localhost:8080/livro
public class LivroController {

    Logger log = LoggerFactory.getLogger(getClass());//criação de uma logger Factory para registrar os logs durante a execução
    
    @Autowired//injeta uma instancia do LivroRepository fazendo com que possa acessar metodos do repositorio
    LivroRepository repository;
    
    @GetMapping//HTTP GET onde retorna uma lista com todos os livros existentes consultando o metodo findAll do repository.
    public List<Livro> index(){
        return repository.findAll();
    }

    @PostMapping//HTTP POST cria um novo livro recebendo as informações dos atributos do Livro no corpo da requisição, salva no BD e retorna 201
    @ResponseStatus(code = CREATED)
    public Livro create(@RequestBody Livro livro){
        log.info("Cadastrando livro" + livro);
        repository.save(livro);
        return livro;
    }

    @GetMapping("{id}")//HTTP GET porém desta vez, retorna um livro com um iD especifico /livro/{id}
    public ResponseEntity<Livro> show (@PathVariable Long id){
        log.info("buscar categoria por id {}", id);
        return repository
                    .findById(id)
                    .map(ResponseEntity::ok)//caso encontre o livro retorna as informações juntamente com o status 200
                    .orElse(ResponseEntity.notFound().build());//Caso não encontre o id informado retorna 404
    }
    
    @DeleteMapping("{id}")//HTTP DELETE buscando pelo id /livro/{id}
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("Apagando livro com id {}", id);
        verifyIfExists(id);//Verifica se o id existe, caso não retorna 404
        repository.deleteById(id);//Deleta objeto com o id informado
        return ResponseEntity.noContent().build();//retorna 204
    }

    @PutMapping("{id}")//HTTP PUT para atualizar um livro pelo id
    public ResponseEntity<Livro> atualizar (@PathVariable Long id, @RequestBody Livro livro){
        log.info("atualizando livro com id {} para {}",id,livro);
        verifyIfExists(id);//Verifica se o id existe, caso não retorna 404
        livro.setId(id);//Faz com que o ID seja o mesmo que o informado não criando um novo livro
        repository.save(livro);//Salva as informações atualizadas
        return ResponseEntity.ok(livro);//Retorna 200
    }

    private void verifyIfExists(Long id) {//metodo para validar se o ID existe
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe categoria com o id informado"));
    }

}
