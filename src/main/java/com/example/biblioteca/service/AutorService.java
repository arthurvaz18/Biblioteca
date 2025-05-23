package com.example.biblioteca.service;

import com.example.biblioteca.model.Autor;

import java.util.Optional;
import java.util.UUID;

public interface AutorService {

    Autor salvar(Autor autorEntidade);

    Optional<Autor> obterPorId(UUID idAutor);

    void deletar(Autor autor);
}
