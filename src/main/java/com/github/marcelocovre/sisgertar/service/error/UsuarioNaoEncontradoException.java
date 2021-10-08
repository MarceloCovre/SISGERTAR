package com.github.marcelocovre.sisgertar.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = "O usuário buscado não existe")
public class UsuarioNaoEncontradoException extends RuntimeException{
}
