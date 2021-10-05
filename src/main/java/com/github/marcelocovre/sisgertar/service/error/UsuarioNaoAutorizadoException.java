package com.github.marcelocovre.sisgertar.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.UNAUTHORIZED,
        reason = "O usuário não possui autorização para fazer essa alteração."
)
public class UsuarioNaoAutorizadoException extends RuntimeException {

}
