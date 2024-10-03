package com.aprendeya.aprendeyaapi.mapper;

import com.aprendeya.aprendeyaapi.dto.UsuarioRegistroDTO;
import com.aprendeya.aprendeyaapi.dto.DeleteUserRequestDTO;
import com.aprendeya.aprendeyaapi.model.entity.Usuario;
import com.aprendeya.aprendeyaapi.model.enums.TipoUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    private final ModelMapper modelMapper;

    public UsuarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        // Configuración de ModelMapper para manejar la conversión de TipoUsuario
        this.modelMapper.typeMap(UsuarioRegistroDTO.class, Usuario.class).addMappings(mapper -> {
            mapper.map(src -> {
                if (src.getTipoUsuario() == null || src.getTipoUsuario().isEmpty()) {
                    return TipoUsuario.ESTUDIANTE; // Valor predeterminado
                }
                return TipoUsuario.valueOf(src.getTipoUsuario());
            }, Usuario::setTipoUsuario);
        });
    }

    public Usuario toEntity(UsuarioRegistroDTO registroDTO) {
        if (registroDTO == null) {
            return null;
        }
        return modelMapper.map(registroDTO, Usuario.class);
    }

    public UsuarioRegistroDTO toDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return modelMapper.map(usuario, UsuarioRegistroDTO.class);
    }
    public Usuario toEntity(DeleteUserRequestDTO deleteUserRequestDTO) {
        if (deleteUserRequestDTO == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(deleteUserRequestDTO.getIdUsuario());
        return usuario;
    }
}
