package com.aprendeya.aprendeyaapi.dto;

import com.aprendeya.aprendeyaapi.model.enums.TipoUsuario;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private TipoUsuario tipoUsuario;
}
