package com.aprendeya.aprendeyaapi.exception;

public class TipoUsuarioNoValidoException extends UsuarioException {
    public TipoUsuarioNoValidoException() {
        super("Tipo de usuario no válido");
    }
}