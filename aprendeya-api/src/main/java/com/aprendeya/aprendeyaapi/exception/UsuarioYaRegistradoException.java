package com.aprendeya.aprendeyaapi.exception;

public class UsuarioYaRegistradoException extends UsuarioException {
    public UsuarioYaRegistradoException() {
        super("El email ya está registrado");
    }
}