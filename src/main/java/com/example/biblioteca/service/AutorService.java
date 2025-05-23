package com.example.biblioteca.service;

import com.example.biblioteca.model.Autor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AutorService {

    Autor salvar(Autor autorEntidade);

    Optional<Autor> obterPorId(UUID idAutor);


    List<Autor> pesquisar(String nome, String nacionalidade);

    void deletar(Autor autor);
}
