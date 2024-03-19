package br.com.bookshelf.Bookshelf.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.Id;
import lombok.Data;

@Entity //Marca a classe como uma entidade JPA
@Data //Anotação usando a biblioteca lombok para criar os getter, setters,constructor e etc
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//Gera o ID automaticamente com o autoincremento
    private Long id;

    @NotBlank(message = "{livro.descricao.notblank}")
    private String nome;

   // @NotBlank(message = "{livro.genero.notblank}")
    private List<String> genero;

    @Positive(message = "livro.paginas.positive")
    private int paginas;

    @NotBlank(message = "{livro.autor.notblank}")
    private String autor;

    @NotBlank(message = "{livro.editora.notblank}")
    private String editora;

    @Past
    private LocalDate dataPublicacao;

    @NotBlank(message = "{livro.capa.notblank}")
    private String capa;
  
}
