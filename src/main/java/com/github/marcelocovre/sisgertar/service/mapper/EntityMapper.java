package com.github.marcelocovre.sisgertar.service.mapper;

public interface EntityMapper<ENTIDADE, DTO> {

    DTO toDTO(ENTIDADE entidade);

    ENTIDADE toEntity(DTO dto);
}
