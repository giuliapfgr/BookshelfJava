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

import br.com.bookshelf.model.Livro;
import br.com.bookshelf.repository.LivroRepository;

@RestController
@RequestMapping("livro")
public class LivroController {

    Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    LivroRepository repository;
    
    @GetMapping
    public List<Livro> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = CREATED)
    public Livro create(@RequestBody Livro livro){
        log.info("Cadastrando livro" + livro);
        repository.save(livro);
        return livro;
    }

    @GetMapping("{id}")
    public ResponseEntity<Livro> show (@PathVariable Long id){
        log.info("buscar categoria por id {}", id);
        return repository
                    .findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("Apagando livro com id {}", id);
        verifyIfExists(id);
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Livro> atualizar (@PathVariable Long id, @RequestBody Livro livro){
        log.info("atualizando livro com id {} para {}",id,livro);
        verifyIfExists(id);
        livro.setId(id);
        repository.save(livro);
        return ResponseEntity.ok(livro);
    }

    private void verifyIfExists(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe categoria com o id informado"));
    }

}
