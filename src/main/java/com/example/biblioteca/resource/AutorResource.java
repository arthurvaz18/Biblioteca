package com.example.biblioteca.resource;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.model.dto.AutorDTO;
import com.example.biblioteca.service.AutorService;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/autores")
public class AutorResource {

    private AutorService autorService;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody AutorDTO autor) {
        Autor autorEntidade = autor.mapearParaAutor();
        autorService.salvar(autorEntidade);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(autorEntidade.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<AutorDTO> obterDetalhes(@PathVariable("id") String id) {

        UUID idAutor = UUID.fromString(id);
        Optional<Autor> autorOptional = autorService.obterPorId(idAutor);

        if (autorOptional.isPresent()) {
            Autor autor = autorOptional.get();
            AutorDTO dto = new AutorDTO(autor);
            return ResponseEntity.ok(dto);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarAutor(@PathVariable("id") String id) {
        UUID idAutor = UUID.fromString(id);
        Optional<Autor> autorOptional = autorService.obterPorId(idAutor);

        if (!autorOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        autorService.deletar(autorOptional.get());

        return ResponseEntity.noContent().build();
    }
}
