package proyecto.cine_garcia.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.cine_garcia.entities.Funcion;
import proyecto.cine_garcia.services.FuncionServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/funciones")
public class FuncionController extends BaseControllerImpl<Funcion, FuncionServiceImpl> {

    @GetMapping("/pelicula/{id}")
    public ResponseEntity<?> getFuncionesPorPelicula(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(servicio.obtenerFuncionesPorPelicula(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body("{\"error\":\"No se encontraron funciones para esa película\"}");
        }
    }

}
