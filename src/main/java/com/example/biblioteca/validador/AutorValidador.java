package com.example.biblioteca.validador;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AutorValidador {

    AutorRepository autorRepository;

    public AutorValidador(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void validar(Autor autor) {
        if (existeAutorCadastrado(autor)) {
            throw new RuntimeException("exise autor cadastrado");
        }

    }

    private boolean existeAutorCadastrado(Autor autor) {
        Optional<Autor> autorCadastrado = autorRepository
                .findByNomeAndDataNascimentoAndNacionalidade
                        (autor.getNome(), autor.getDataNascimento(), autor.getNacionalidade());

        if (autor.getId() == null) {
            return autorCadastrado.isPresent();
        }
        return autor.getId().equals(autorCadastrado.get().getId()) && autorCadastrado.isPresent();

    }
}
