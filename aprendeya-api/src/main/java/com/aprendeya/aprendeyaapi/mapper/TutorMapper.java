package com.aprendeya.aprendeyaapi.mapper;

import com.aprendeya.aprendeyaapi.dto.TutorPerfilRequestDTO;
import com.aprendeya.aprendeyaapi.dto.TutorResponseDTO;
import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TutorMapper {

    private final ModelMapper modelMapper;

    public Tutor convertToEntity(TutorPerfilRequestDTO tutorPerfilRequestDTO){
        return modelMapper.map(tutorPerfilRequestDTO, Tutor.class);
    }

    public TutorResponseDTO convertToDTO(Tutor tutor){
        return modelMapper.map(tutor, TutorResponseDTO.class);
    }

    public List<TutorResponseDTO> convertToListDTO(List<Tutor> tutores){
        return tutores.stream().map(this::convertToDTO).toList();
    }
}
