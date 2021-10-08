package com.github.marcelocovre.sisgertar.domain.enumerations;

<<<<<<< HEAD
import com.github.marcelocovre.sisgertar.service.error.StatusInexistenteException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

=======
import lombok.AllArgsConstructor;
import lombok.Getter;

>>>>>>> 9cbbe6330b1691043cd6e6981c8b30396616780e
@Getter
@AllArgsConstructor
public enum StatusTarefaEnum {

    A_FAZER(1L, "A Fazer"),
    FAZENDO(2L, "Fazendo"),
    PAUSADA(3L, "Pausada"),
    FEITO(4L,"Feito");

    private Long id;
    private String descricao;

<<<<<<< HEAD
    public static StatusTarefaEnum obterPorId(Long id){
        return Arrays.stream(StatusTarefaEnum.values())
                .filter(enumeration -> id.equals(enumeration.getId()))
                .findFirst().orElseThrow(StatusInexistenteException::new);
    }

=======
>>>>>>> 9cbbe6330b1691043cd6e6981c8b30396616780e
}
