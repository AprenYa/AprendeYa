package com.aprendeya.aprendeyaapi.api;

import com.aprendeya.aprendeyaapi.dto.CustomTutorPerfilDTO;
import com.aprendeya.aprendeyaapi.dto.TutorPerfilDTO;
import com.aprendeya.aprendeyaapi.service.TutorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
public class PerfilActController {

    @Autowired
    private TutorServices tutorService;

    @PutMapping("/actualizar/{idTutor}")
    public ResponseEntity<?> actualizarPerfil(@PathVariable Integer idTutor,
                                              @RequestBody CustomTutorPerfilDTO tutorPerfilDTO) {
        try {
            CustomTutorPerfilDTO updatedTutor = tutorService.actualizarPerfil(idTutor, tutorPerfilDTO);
            return ResponseEntity.ok(updatedTutor);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @GetMapping("/perfil/{idTutor}")
    public ResponseEntity<TutorPerfilDTO> obtenerPerfil(@PathVariable Integer idTutor) {
        TutorPerfilDTO tutorPerfilDTO = tutorService.obtenerPerfil(idTutor);
        return ResponseEntity.ok(tutorPerfilDTO);
    }
}
