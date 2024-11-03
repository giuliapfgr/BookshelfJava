package br.com.bookshelf.Bookshelf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_do_usuario")
    private Integer id;

    @NotBlank(message = "{usuario.nome.notblank}")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotBlank(message = "{usuario.email.notblank}")
    @Column(name = "email", nullable = false)
    private String email;

    @Min(value = 1, message = "{usuario.idade.min}")
    @Column(name = "idade", nullable = false)
    private int idade;

    @ManyToOne
    @JoinColumn(name = "id_do_livro", nullable = false)
    private Livro livro;
}
