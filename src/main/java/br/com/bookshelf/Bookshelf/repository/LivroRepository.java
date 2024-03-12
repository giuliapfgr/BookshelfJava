package br.com.bookshelf.Bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bookshelf.Bookshelf.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}
