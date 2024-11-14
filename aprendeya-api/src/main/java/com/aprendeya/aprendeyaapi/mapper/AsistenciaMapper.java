package com.aprendeya.aprendeyaapi.mapper;

import com.aprendeya.aprendeyaapi.dto.AsistenciaResponseDTO;
import com.aprendeya.aprendeyaapi.model.entity.Asistencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AsistenciaMapper {

    private final ModelMapper modelMapper;

    public AsistenciaResponseDTO convertToDTO(Asistencia asistencia) {
        return modelMapper.map(asistencia, AsistenciaResponseDTO.class);
    }

}
