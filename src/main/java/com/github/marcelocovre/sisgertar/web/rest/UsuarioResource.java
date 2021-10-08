package com.github.marcelocovre.sisgertar.web.rest;

import com.github.marcelocovre.sisgertar.service.UsuarioService;
import com.github.marcelocovre.sisgertar.service.dto.UsuarioDTO;
import com.github.marcelocovre.sisgertar.service.dto.UsuarioListDTO;
<<<<<<< HEAD
import liquibase.pro.packaged.S;
=======
>>>>>>> 9cbbe6330b1691043cd6e6981c8b30396616780e
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.save(usuarioDTO));
    }

<<<<<<< HEAD
    @GetMapping("/obter-por-hash/{hash}")
    public ResponseEntity<UsuarioDTO> obterPorHash(@PathVariable("hash") String hash){
        return ResponseEntity.of(usuarioService.obterPorHash(hash));
    }

=======
>>>>>>> 9cbbe6330b1691043cd6e6981c8b30396616780e
//    @GetMapping
//    public ResponseEntity<List<UsuarioListDTO>> findAll() {
//        return ResponseEntity.ok(usuarioService.findAll());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UsuarioDTO> findById(@PathVariable("id") Long id) {
//        return ResponseEntity.of(usuarioService.findById(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UsuarioDTO> update(@PathVariable("id") Long id, @RequestBody UsuarioDTO usuarioDTO) {
//        usuarioDTO.setId(id);
//        return ResponseEntity.ok(usuarioService.save(usuarioDTO));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
//        usuarioService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }

}
