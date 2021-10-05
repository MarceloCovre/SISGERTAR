package com.github.marcelocovre.sisgertar.repository;

import com.github.marcelocovre.sisgertar.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
