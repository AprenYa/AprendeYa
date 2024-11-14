package com.aprendeya.aprendeyaapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SesionDTO {

    @NotBlank(message = "El email no puede estar vacio")
    @Email
    private String email;
    @NotBlank(message = "La contraseña no puede estar vacia")
    private String contraseña;
}
