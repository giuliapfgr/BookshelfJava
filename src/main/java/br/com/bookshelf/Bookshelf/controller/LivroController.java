package br.com.bookshelf.Bookshelf.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bookshelf.model.Livro;

@Controller
@RequestMapping("livro")
public class LivroController {

    Logger log = LoggerFactory.getLogger(getClass());
    
    List<Livro> repository = new ArrayList<>();
    
    
}
