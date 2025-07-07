package com.example.biblioteca.model.dto;

import com.example.biblioteca.model.Autor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

public class AutorDTO {
    private UUID id;
    @NotBlank(message = "O campo é Obrigatório")
    private String nome;
    @NotBlank(message = "O campo é Obrigatório")
    private LocalDate dataNascimento;
    @NotBlank(message = "O campo é Obrigatório")
    private String nacionalidade;

    public AutorDTO() {
    }

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.dataNascimento = autor.getDataNascimento();
        this.nacionalidade = autor.getNacionalidade();
    }

    public Autor mapearParaAutor() {
        Autor autor = new Autor();
        autor.setNacionalidade(nacionalidade);
        autor.setDataNascimento(dataNascimento);
        autor.setNome(nome);
        return autor;
    }

    public AutorDTO(UUID id, String nome, LocalDate dataNascimento, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
