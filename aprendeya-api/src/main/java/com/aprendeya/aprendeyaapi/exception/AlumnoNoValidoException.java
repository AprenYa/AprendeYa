package com.aprendeya.aprendeyaapi.exception;

public class AlumnoNoValidoException extends UsuarioException {
    public AlumnoNoValidoException() {
        super("El ID del alumno no es válido");
    }
}