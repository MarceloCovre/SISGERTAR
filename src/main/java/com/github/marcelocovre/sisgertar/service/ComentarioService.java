package com.github.marcelocovre.sisgertar.service;

import com.github.marcelocovre.sisgertar.domain.Comentario;
import com.github.marcelocovre.sisgertar.repository.ComentarioRepository;
import com.github.marcelocovre.sisgertar.service.dto.ComentarioDTO;
import com.github.marcelocovre.sisgertar.service.dto.ComentarioListDTO;
import com.github.marcelocovre.sisgertar.service.mapper.ComentarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final ComentarioMapper comentarioMapper;

    public List<ComentarioListDTO> findAll() {
        return comentarioRepository.findAll().stream()
                .map(comentarioMapper::toListDTO)
                .collect(Collectors.toList());
    }

    public ComentarioDTO save(ComentarioDTO comentarioDTO) {
        Comentario comentario = comentarioMapper.toEntity(comentarioDTO);
        comentarioRepository.save(comentario);
        return comentarioMapper.toDTO(comentario);
    }

    public Optional<ComentarioDTO> findById(Long id) {
        return comentarioRepository.findById(id).map(comentarioMapper::toDTO);
    }

    public void deleteById(Long id) {
        comentarioRepository.deleteById(id);
    }
}
