package br.com.bookshelf.Bookshelf.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_do_livro")
    private Long id;

    @NotBlank(message = "{livro.nome.notblank}")
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "genero")
    private String genero;

    @Positive(message = "{livro.paginas.positive}")
    @Column(name = "paginas")
    private int paginas;

    @NotBlank(message = "{livro.autor.notblank}")
    @Column(name = "autor", nullable = false)
    private String autor;

    @NotBlank(message = "{livro.editora.notblank}")
    @Column(name = "editora", nullable = false)
    private String editora;

    @Past(message = "{livro.data_de_publicacao.past}")
    @Column(name = "data_de_publicacao")
    private LocalDate dataPublicacao;

    @NotBlank(message = "{livro.capa.notblank}")
    @Column(name = "capa")
    private String capa;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> usuarios;
}
