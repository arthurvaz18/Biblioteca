package com.example.biblioteca.model.dto;

import com.example.biblioteca.model.Autor;

import java.time.LocalDate;

public class AutorDTO {
    private String nome;
    private LocalDate dataNascimento;
    private String nacionalidade;

    public Autor mapearParaAutor(){
        Autor autor = new Autor();
        autor.setNacionalidade(nacionalidade);
        autor.setDataNascimento(dataNascimento);
        autor.setNome(nome);
        return autor;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
}
