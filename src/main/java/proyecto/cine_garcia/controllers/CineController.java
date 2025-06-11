package proyecto.cine_garcia.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.cine_garcia.entities.Cine;
import proyecto.cine_garcia.services.CineServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/cines")
public class CineController extends BaseControllerImpl<Cine, CineServiceImpl> {

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+e.getMessage()+"\"}"));
        }
    }
}
