package com.example.biblioteca.service;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }
}
