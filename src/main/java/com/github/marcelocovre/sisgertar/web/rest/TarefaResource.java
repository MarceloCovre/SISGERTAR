package com.github.marcelocovre.sisgertar.web.rest;

import com.github.marcelocovre.sisgertar.service.TarefaService;
import com.github.marcelocovre.sisgertar.service.dto.TarefaDTO;
<<<<<<< HEAD
import com.github.marcelocovre.sisgertar.service.dto.TarefaFilterDTO;
import com.github.marcelocovre.sisgertar.service.dto.TarefaListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
import com.github.marcelocovre.sisgertar.service.dto.TarefaListDTO;
import lombok.RequiredArgsConstructor;
>>>>>>> 9cbbe6330b1691043cd6e6981c8b30396616780e
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
public class TarefaResource {

    private final TarefaService tarefaService;

    @GetMapping
<<<<<<< HEAD
    public ResponseEntity<Page<TarefaListDTO>> findAll(@ModelAttribute TarefaFilterDTO filterDTO, Pageable page) {
        return ResponseEntity.ok(tarefaService.findAll(filterDTO, page));
=======
    public ResponseEntity<List<TarefaListDTO>> findAll() {
        return ResponseEntity.ok(tarefaService.findAll());
>>>>>>> 9cbbe6330b1691043cd6e6981c8b30396616780e
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> create(@RequestBody TarefaDTO tarefaDTO) {
        return ResponseEntity.ok(tarefaService.save(tarefaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.of(tarefaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> update(@PathVariable("id") Long id, @RequestBody TarefaDTO tarefaDTO) {
        tarefaDTO.setId(id);
        return ResponseEntity.ok(tarefaService.save(tarefaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        tarefaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TarefaDTO> atualizarStatus(@PathVariable("id") Long id, @RequestBody TarefaDTO tarefaDTO, @RequestParam("hash") String hash) {
        tarefaDTO.setId(id);
        return ResponseEntity.ok(tarefaService.atualizarStatus(tarefaDTO, hash));
    }

}
