package com.github.marcelocovre.sisgertar.service.mapper;

import com.github.marcelocovre.sisgertar.domain.Tarefa;
<<<<<<< HEAD
import com.github.marcelocovre.sisgertar.domain.Usuario;
import com.github.marcelocovre.sisgertar.service.dto.TarefaDTO;
import com.github.marcelocovre.sisgertar.service.dto.TarefaListDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Objects;
import java.util.Optional;
=======
import com.github.marcelocovre.sisgertar.service.dto.TarefaDTO;
import com.github.marcelocovre.sisgertar.service.dto.TarefaListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
>>>>>>> 9cbbe6330b1691043cd6e6981c8b30396616780e


@Mapper(uses = { UsuarioMapper.class })
public interface TarefaMapper extends EntityMapper<Tarefa, TarefaDTO>{

    @Override
    @Mapping(source = "responsavel.id", target = "idResponsavel")
    TarefaDTO toDTO(Tarefa tarefa);

    @Override
    @Mapping(source = "idResponsavel", target = "responsavel.id")
    Tarefa toEntity(TarefaDTO tarefaDTO);

    TarefaListDTO toListDTO(Tarefa tarefa);

<<<<<<< HEAD
    @AfterMapping
    default void verificarElementosNulos(@MappingTarget Tarefa tarefa) {
        tarefa.setResponsavel(
                Optional.ofNullable(tarefa.getResponsavel()).orElseGet(Usuario::new));
        if (Objects.isNull(tarefa.getResponsavel().getId())) {
            tarefa.setResponsavel(null);
        }
    }
=======
>>>>>>> 9cbbe6330b1691043cd6e6981c8b30396616780e
}
