package br.com.bookshelf.Bookshelf.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;
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
import lombok.extern.slf4j.Slf4j;

@RestController //Anotação para informar que a classe é um controller e que os metodos tratam solicitações HTTP
@RequestMapping("livro")//Anotação para mapear todas as solicitações feitas para a url /livro exemplo localhost:8080/livro
@Slf4j
public class LivroController {

       
    @Autowired//injeta uma instancia do LivroRepository fazendo com que possa acessar metodos do repositorio
    LivroRepository repository;
    
    @GetMapping//HTTP GET onde retorna uma lista com todos os livros existentes consultando o metodo findAll do repository.
    public List<Livro> index(){
        return repository.findAll();
    }

    @PostMapping//HTTP POST cria um novo livro recebendo as informações dos atributos do Livro no corpo da requisição, salva no BD e retorna 201
    @ResponseStatus(CREATED)
    public Livro create(@RequestBody Livro livro){
        log.info("Cadastrando livro" + livro);
        return repository.save(livro);
    }

    @GetMapping("{id}")//HTTP GET porém desta vez, retorna um livro com um iD especifico /livro/{id}
    public ResponseEntity<Livro> show (@PathVariable Long id){
        log.info("buscar categoria por id {}", id);
        return repository
                    .findById(id)
                    .map(ResponseEntity::ok)//caso encontre o livro retorna as informações juntamente com o status 200
                    .orElse(ResponseEntity.notFound().build());//Caso não encontre o id informado retorna 404
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)//HTTP DELETE buscando pelo id /livro/{id}
    public void destroy(@PathVariable Long id){
        log.info("Apagando livro com id {}", id);
        verifyIfExists(id);//Verifica se o id existe, caso não retorna 404
        repository.deleteById(id);//Deleta objeto com o id informado
        
    }

    @PutMapping("{id}")//HTTP PUT para atualizar um livro pelo id
    public Livro atualizar (@PathVariable Long id, @RequestBody Livro livro){
        log.info("atualizando livro com id {} para {}",id,livro);
        verifyIfExists(id);//Verifica se o id existe, caso não retorna 404
        livro.setId(id);//Faz com que o ID seja o mesmo que o informado não criando um novo livro
        return repository.save(livro);//Retorna 200
    }

    private void verifyIfExists(Long id) {//metodo para validar se o ID existe
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe categoria com o id informado"));
    }

}
