package com.aprendeya.aprendeyaapi.service;

import com.aprendeya.aprendeyaapi.dto.UsuarioRegistroDTO;
import com.aprendeya.aprendeyaapi.model.entity.Alumno;
import com.aprendeya.aprendeyaapi.model.entity.Padre;
import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import com.aprendeya.aprendeyaapi.model.entity.Usuario;

public interface UsuarioService {
    Usuario registerUser(UsuarioRegistroDTO registroDTO);
    Tutor registerTutor(Tutor tutor);
    Padre registerPadre(Padre padre);
    Alumno registerAlumno(Alumno alumno);
}
