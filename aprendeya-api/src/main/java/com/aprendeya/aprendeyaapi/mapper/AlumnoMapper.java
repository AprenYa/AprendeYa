package com.aprendeya.aprendeyaapi.mapper;

import com.aprendeya.aprendeyaapi.dto.AlumnoPerfilRequestDTO;
import com.aprendeya.aprendeyaapi.dto.AlumnoResponseDTO;
import com.aprendeya.aprendeyaapi.model.entity.Alumno;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class AlumnoMapper {

    private final ModelMapper modelMapper;

    public Alumno convertToEntity(AlumnoPerfilRequestDTO alumnoRequestDTO) {
        return modelMapper.map(alumnoRequestDTO, Alumno.class);
    }

    public AlumnoResponseDTO convertToDTO(Alumno alumno) {
        return modelMapper.map(alumno, AlumnoResponseDTO.class);
    }

}
