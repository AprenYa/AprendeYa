package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.idUsuario=:id")
    Usuario buscarUsuarioPorID(@Param("id") Integer id);

    @Query("SELECT u FROM Usuario u WHERE u.email =:email")
    Usuario inicioSesionUsuario(@Param("email") String email);

    Optional<Usuario> findOneByEmail(String email);
}
