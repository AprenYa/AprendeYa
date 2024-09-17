package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository {

    @Query("SELECT u FROM Usuario u WHERE u.idUsuario=:id")
    Usuario buscarUsuarioPorID(@Param("id") Integer id);
}
