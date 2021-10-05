package com.github.marcelocovre.sisgertar.service.mapper;

import com.github.marcelocovre.sisgertar.domain.Comentario;
import com.github.marcelocovre.sisgertar.service.dto.ComentarioDTO;
import com.github.marcelocovre.sisgertar.service.dto.ComentarioListDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ComentarioMapper {

    ComentarioDTO toDTO(Comentario comentario);

    ComentarioListDTO toListDTO(Comentario comentario);

    Comentario toEntity(ComentarioDTO comentarioDTO);
}
