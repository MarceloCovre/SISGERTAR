package com.github.marcelocovre.sisgertar.service;

import com.github.marcelocovre.sisgertar.domain.Tarefa;
import com.github.marcelocovre.sisgertar.domain.Usuario;
import com.github.marcelocovre.sisgertar.domain.enumerations.StatusTarefaEnum;
import com.github.marcelocovre.sisgertar.repository.TarefaRepository;
import com.github.marcelocovre.sisgertar.service.dto.*;
import com.github.marcelocovre.sisgertar.service.error.TarefaNaoEncontradaException;
import com.github.marcelocovre.sisgertar.service.error.UsuarioNaoAutorizadoException;
import com.github.marcelocovre.sisgertar.service.mapper.TarefaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;
    private final UsuarioService usuarioService;
    private final SendMailService sendMailService;

    public List<TarefaListDTO> findAll() {
        return tarefaRepository.findAll().stream()
                .map(tarefaMapper::toListDTO)
                .collect(Collectors.toList());
    }

    public Page<TarefaListDTO> findAll(TarefaFilterDTO filterDTO, Pageable page){
        return tarefaRepository.filtrarTarefas(filterDTO, page);
    }

    public TarefaDTO save(TarefaDTO tarefaDTO) {
        validarResponsavel(tarefaDTO);
        definirStatusInicial(tarefaDTO);
        Tarefa tarefa = tarefaMapper.toEntity(tarefaDTO);
        tarefa.setIdStatus(StatusTarefaEnum.A_FAZER.getId());
        tarefaRepository.save(tarefa);
        return tarefaMapper.toDTO(tarefa);
    }

    private void validarResponsavel(TarefaDTO tarefaDTO){
        if (Objects.nonNull(tarefaDTO.getIdResponsavel())){
            usuarioService.obterPorId(tarefaDTO.getIdResponsavel());
        }
    }

    private void definirStatusInicial(TarefaDTO tarefaDTO){
        tarefaDTO.setIdStatus(StatusTarefaEnum.A_FAZER.getId());
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
        atualizarStatus(tarefaEmBanco, tarefaDTO);
        notificarAcompanhadores(tarefaEmBanco);
        tarefaRepository.save(tarefaEmBanco);
        return tarefaMapper.toDTO(tarefaEmBanco);
    }

    private void validarResponsavel(Tarefa tarefa, String hash) {
        UsuarioDTO responsavel = usuarioService.obterPorId(tarefa.getResponsavel().getId());
        if (!responsavel.getHash().equals(hash)) {
            throw new UsuarioNaoAutorizadoException();
        }
    }

    private void atualizarStatus(Tarefa tarefa, TarefaDTO tarefaDTO) {
        tarefa.setIdStatus(tarefaDTO.getIdStatus());
    }

    private void notificarAcompanhadores(Tarefa tarefa) {
        tarefa.getAcompanhadores().forEach(acompanhador -> {
            EmailDTO emailDTO = construirEmail(tarefa, acompanhador);
            sendMailService.sendMail(emailDTO);
        });
    }

    private EmailDTO construirEmail(Tarefa tarefa, Usuario acompanhador) {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setAssunto("Movimentação e, tarefa " + tarefa.getNome());
        emailDTO.setCorpo("O novo status da tarefa é " + StatusTarefaEnum.obterPorId(tarefa.getIdStatus()).getDescricao());
        emailDTO.setDestinatario(acompanhador.getEmail());
        return emailDTO;
    }
}
