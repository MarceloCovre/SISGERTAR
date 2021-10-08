package com.github.marcelocovre.sisgertar.repository;

import com.github.marcelocovre.sisgertar.domain.Tarefa;
<<<<<<< HEAD
import com.github.marcelocovre.sisgertar.service.dto.TarefaFilterDTO;
import com.github.marcelocovre.sisgertar.service.dto.TarefaListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
=======
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> 9cbbe6330b1691043cd6e6981c8b30396616780e
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
<<<<<<< HEAD

    @Query(
            "SELECT new com.github.marcelocovre.sisgertar.service.dto.TarefaListDTO(" +
            "   tarefa.id, " +
            "   tarefa.nome " +
            ") FROM " +
            "   Tarefa tarefa " +
            "WHERE " +
            "   tarefa.nome LIKE %:#{#filtro.nome}%")
    Page<TarefaListDTO> filtrarTarefas(@Param("filtro") TarefaFilterDTO filterDTO, Pageable page);

=======
>>>>>>> 9cbbe6330b1691043cd6e6981c8b30396616780e
}
