package br.com.bookshelf.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private List<String> genero;
    private int paginas;
    private String autor;
    private String editora;
    private Date dataPublicacao;
    private String capa;
  
}
