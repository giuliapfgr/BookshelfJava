package br.com.bookshelf.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
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

        
    public Livro(Long id, String nome, List<String> genero, int paginas, String autor, String editora,
            Date dataPublicacao, String capa) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.paginas = paginas;
        this.autor = autor;
        this.editora = editora;
        this.dataPublicacao = dataPublicacao;
        this.capa = capa;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<String> getGenero() {
        return genero;
    }
    public void setGenero(List<String> genero) {
        this.genero = genero;
    }
    public int getPaginas() {
        return paginas;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public Date getDataPublicacao() {
        return dataPublicacao;
    }
    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
    public String getCapa() {
        return capa;
    }
    public void setCapa(String capa) {
        this.capa = capa;
    }
    
    
}
