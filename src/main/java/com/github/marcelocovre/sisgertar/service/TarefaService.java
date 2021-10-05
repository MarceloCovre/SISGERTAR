package com.github.marcelocovre.sisgertar.service;

import com.github.marcelocovre.sisgertar.domain.Tarefa;
import com.github.marcelocovre.sisgertar.domain.enumerations.StatusTarefaEnum;
import com.github.marcelocovre.sisgertar.repository.TarefaRepository;
import com.github.marcelocovre.sisgertar.service.dto.TarefaDTO;
import com.github.marcelocovre.sisgertar.service.dto.TarefaListDTO;
import com.github.marcelocovre.sisgertar.service.error.TarefaNaoEncontradaException;
import com.github.marcelocovre.sisgertar.service.error.UsuarioNaoAutorizadoException;
import com.github.marcelocovre.sisgertar.service.mapper.TarefaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;

    public List<TarefaListDTO> findAll() {
        return tarefaRepository.findAll().stream()
                .map(tarefaMapper::toListDTO)
                .collect(Collectors.toList());
    }

    public TarefaDTO save(TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaMapper.toEntity(tarefaDTO);
        tarefa.setIdStatus(StatusTarefaEnum.A_FAZER.getId());
        tarefaRepository.save(tarefa);
        return tarefaMapper.toDTO(tarefa);
    }

    public Optional<TarefaDTO> findById(Long id) {
        return tarefaRepository.findById(id).map(tarefaMapper::toDTO);
    }

    public void deleteById(Long id) {
        tarefaRepository.deleteById(id);
    }

    public TarefaDTO atualizarStatus(TarefaDTO tarefaDTO, String hash) {
        Tarefa tarefaEmBanco = tarefaRepository.findById(tarefaDTO.getId())
                .orElseThrow(TarefaNaoEncontradaException::new);
        validarResponsavel(tarefaEmBanco, hash);
        tarefaEmBanco.setIdStatus(tarefaDTO.getIdStatus());
        tarefaRepository.save(tarefaEmBanco);
        return tarefaMapper.toDTO(tarefaEmBanco);
    }

    private void validarResponsavel(Tarefa tarefa, String hash) {
        if (!tarefa.getResponsavel().getHash().equals(hash)){
            throw new UsuarioNaoAutorizadoException();
        }
    }

}
