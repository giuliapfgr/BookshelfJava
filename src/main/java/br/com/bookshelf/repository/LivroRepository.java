package br.com.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bookshelf.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}
