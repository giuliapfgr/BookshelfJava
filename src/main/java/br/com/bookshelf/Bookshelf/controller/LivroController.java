package br.com.bookshelf.Bookshelf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

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

        for(Livro livro : repository){
            if(livro.getId().equals(id))
                return ResponseEntity.ok(livro)

            return ResponseEntity.notFound().build();
        }

        
        //if(livro.isEmpty())
        //    return ResponseEntity.notFound().build();
        
       
    }

    
    
}
