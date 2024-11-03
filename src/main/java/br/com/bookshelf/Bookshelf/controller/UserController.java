package br.com.bookshelf.Bookshelf.controller;

import br.com.bookshelf.Bookshelf.model.Livro;
import br.com.bookshelf.Bookshelf.model.User;
import br.com.bookshelf.Bookshelf.repository.LivroRepository;
import br.com.bookshelf.Bookshelf.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("usuario")
@Slf4j
public class UserController{

    @Autowired
    UserRepository repository;

    @GetMapping
    public List<User> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public User create(@RequestBody User user){
        log.info("Cadastrando usuário" + user);
        return repository.save(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> show (@PathVariable Integer id) {
        log.info("buscar usuário por id {}", id);
        return repository
                .findById(Long.valueOf(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Integer id){
        log.info("Apagando usuário com id {}", id);
        verifyIfExists(id);
        repository.deleteById(Long.valueOf(id));

    }

    @PutMapping("{id}")
    public User atualizar (@PathVariable Integer id, @RequestBody User user){
        log.info("atualizando usuário com id {} para {}",id,user);
        verifyIfExists(id);
        user.setId(Long.valueOf(id));
        return repository.save(user);
    }

    private void verifyIfExists(Integer id) {
        repository
                .findById(Long.valueOf(id))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe categoria com o id informado"));
    }

}