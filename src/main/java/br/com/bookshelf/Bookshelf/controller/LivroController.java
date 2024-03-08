package br.com.bookshelf.Bookshelf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bookshelf.model.Livro;

@Controller
@RequestMapping("livro")
public class LivroController {

    Logger log = LoggerFactory.getLogger(getClass());
    
    List<Livro> repository = new ArrayList<>();
    
    @GetMapping
    public List<Livro> index(){
        return repository;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Livro create(@RequestBody Livro livro){
        log.info("Cadastrando livro" + livro);
        repository.add(livro);
        return livro;
    }

    @GetMapping("{id}")
    public ResponseEntity<Livro> show (@PathVariable Long id){
        log.info("buscar categoria por id {}", id);

        var livroEncontrado = getLivroById(id);

        if( livroEncontrado.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(livroEncontrado.get());

    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("Apagando livro com id {}", id);

        var livroEncontrado = getLivroById(id);

        if(livroEncontrado.isEmpty()){
           return ResponseEntity.notFound().build();
        }
        repository.remove(livroEncontrado.get());
        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Livro> atualizar (@PathVariable Long id, @RequestBody Livro livro){
        log.info("atualizando livro com id {} para {}",id,livro);
        var livroEncontrado = getLivroById(id);

        if(livroEncontrado.isEmpty()){
            return ResponseEntity.notFound().build();
         }

        var livroAntigo = livroEncontrado.get();
        var livroNovo = new Livro(id, livro.getNome(),
                livro.getGenero(),livro.getPaginas(),
                livro.getAutor(), livro.getEditora(),
                livro.getDataPublicacao(),livro.getCapa());

        repository.remove(livroAntigo);
        repository.add(livroNovo);

        return ResponseEntity.ok(livroNovo);
        
    }


    private Optional<Livro> getLivroById(Long id) {
        var livroEncontrado = repository
                                    .stream()
                                    .filter( c -> c.getId().equals(id))
                                    .findFirst();
        return livroEncontrado;
    }

    
    
}
