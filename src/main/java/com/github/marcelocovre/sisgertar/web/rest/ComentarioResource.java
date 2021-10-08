package com.github.marcelocovre.sisgertar.web.rest;

import com.github.marcelocovre.sisgertar.service.ComentarioService;
import com.github.marcelocovre.sisgertar.service.dto.ComentarioDTO;
import com.github.marcelocovre.sisgertar.service.dto.ComentarioListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
@RequiredArgsConstructor
public class ComentarioResource {

    private final ComentarioService comentarioService;

    @GetMapping
    public ResponseEntity<List<ComentarioListDTO>> findAll() {
        return ResponseEntity.ok(comentarioService.findAll());
    }

    @PostMapping
    public ResponseEntity<ComentarioDTO> create (@RequestBody ComentarioDTO comentarioDTO) {
        return ResponseEntity.ok(comentarioService.save(comentarioDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioDTO> findById(@PathVariable("id") Long id) {
        return  ResponseEntity.of(comentarioService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComentarioDTO> updade(@PathVariable("id") Long id, @RequestBody ComentarioDTO comentarioDTO) {
        comentarioDTO.setId(id);
        return ResponseEntity.ok(comentarioService.save(comentarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        comentarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
