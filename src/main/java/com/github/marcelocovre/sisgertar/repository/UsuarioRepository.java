package com.github.marcelocovre.sisgertar.repository;

import com.github.marcelocovre.sisgertar.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value =
            "SELECT " +
            "   * " +
            "FROM " +
            "   usuario " +
            "WHERE" +
            "   usuario.hash = :hash", nativeQuery = true)
    Optional<Usuario> findByHash(@Param("hash") String hash);
}
