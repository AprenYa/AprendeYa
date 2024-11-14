package com.aprendeya.aprendeyaapi.mapper;

import com.aprendeya.aprendeyaapi.dto.PagoResponseDTO;
import com.aprendeya.aprendeyaapi.model.entity.Pago;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PagoMapper {

    private final ModelMapper modelMapper;

    public PagoResponseDTO convertToDTO(Pago pago) {
        return modelMapper.map(pago, PagoResponseDTO.class);
    }
}
