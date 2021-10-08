package com.github.marcelocovre.sisgertar.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "A tarefa procurada não existe."
)
public class TarefaNaoEncontradaException extends RuntimeException {

}
