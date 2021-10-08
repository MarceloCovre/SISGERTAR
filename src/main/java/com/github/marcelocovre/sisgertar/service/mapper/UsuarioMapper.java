package com.github.marcelocovre.sisgertar.service.mapper;


import com.github.marcelocovre.sisgertar.domain.Usuario;
import com.github.marcelocovre.sisgertar.service.dto.UsuarioDTO;
import com.github.marcelocovre.sisgertar.service.dto.UsuarioListDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UsuarioMapper extends EntityMapper<Usuario, UsuarioDTO>{

    UsuarioDTO toDTO(Usuario usuario);

    UsuarioListDTO toListDTO(Usuario usuario);

    Usuario toEntity(UsuarioDTO usuarioDTO);

}
