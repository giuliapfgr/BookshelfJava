package br.com.bookshelf.Bookshelf.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro_seq")
    @SequenceGenerator(name = "livro_seq", sequenceName = "livro_seq", allocationSize = 1)
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

    @Column(name = "data_de_publicacao")
    private int dataPublicacao;

    @NotBlank(message = "{livro.capa.notblank}")
    @Column(name = "capa")
    private String capa;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> usuarios;
}
