package com.aprendeya.aprendeyaapi.api;

import com.aprendeya.aprendeyaapi.dto.UsuarioRegistroDTO;
import com.aprendeya.aprendeyaapi.mapper.UsuarioMapper;
import com.aprendeya.aprendeyaapi.model.entity.Usuario;
import com.aprendeya.aprendeyaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registerUser(@RequestBody UsuarioRegistroDTO registroDTO) {
        Usuario nuevoUsuario = usuarioService.registerUser(registroDTO);
        return ResponseEntity.ok(nuevoUsuario);
    }

}
