package br.com.bookshelf.Bookshelf.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity //Marca a classe como uma entidade JPA
@Data //Anotação usando a biblioteca lombok para criar os getter, setters,constructor e etc
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//Gera o ID automaticamente com o autoincremento
    private Long id;
    private String nome;
    private List<String> genero;
    private int paginas;
    private String autor;
    private String editora;
    private Date dataPublicacao;
    private String capa;
  
}
