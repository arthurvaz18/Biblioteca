package com.example.biblioteca.service;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.validador.AutorValidador;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorServiceImpl implements AutorService {

    AutorRepository autorRepository;

    AutorValidador autorValidador;

    public AutorServiceImpl(AutorRepository autorRepository, AutorValidador autorValidador) {
        this.autorRepository = autorRepository;
        this.autorValidador = autorValidador;
    }

    public Autor salvar(Autor autor) {
        autorValidador.validar(autor);
        return autorRepository.save(autor);
    }

    public Optional<Autor> obterPorId(UUID id) {
        return autorRepository.findById(id);
    }

    public void deletar(Autor autor) {
        autorRepository.delete(autor);
    }
    public void atualizar(Autor autor) {
        autorValidador.validar(autor);
        autorRepository.save(autor);
    }

    @Override
    public List<Autor> pesquisar(String nome, String nacionalidade) {
        if (nome != null && nacionalidade != null) {
            return autorRepository.findByNomeAndNacionalidade(nome, nacionalidade);
        } else if (nome != null) {
            return autorRepository.findByNome(nome);
        } else if (nacionalidade != null) {
            return autorRepository.findByNacionalidade(nacionalidade);
        } else {
            return autorRepository.findAll();
        }
    }
}
