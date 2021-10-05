package com.github.marcelocovre.sisgertar.service;

import com.github.marcelocovre.sisgertar.domain.Usuario;
import com.github.marcelocovre.sisgertar.repository.UsuarioRepository;
import com.github.marcelocovre.sisgertar.service.dto.UsuarioDTO;
import com.github.marcelocovre.sisgertar.service.dto.UsuarioListDTO;
import com.github.marcelocovre.sisgertar.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public List<UsuarioListDTO> findAll() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toListDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setHash(UUID.randomUUID().toString());
        usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    public Optional<UsuarioDTO> findById(Long id) {
        return usuarioRepository.findById(id).map(usuarioMapper::toDTO);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
