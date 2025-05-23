package com.example.biblioteca.resource;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.model.dto.AutorDTO;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorResource {

    private AutorService autorService;

    public AutorResource(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody AutorDTO autor) {
        Autor autorEntidade = autor.mapearParaAutor();
        autorService.salvar(autorEntidade);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(autorEntidade.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
