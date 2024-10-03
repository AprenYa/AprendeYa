package com.aprendeya.aprendeyaapi.api;

import com.aprendeya.aprendeyaapi.dto.DeleteUserRequestDTO;
import com.aprendeya.aprendeyaapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> deleteUser(@RequestBody DeleteUserRequestDTO requestDTO) {
        if (requestDTO.getIdUsuario() == null) {
            return ResponseEntity.badRequest().body("El ID no puede ser nulo.");
        }
        usuarioService.deleteUser(requestDTO);
        return ResponseEntity.ok("Usuario eliminado con éxito.");
    }

}
