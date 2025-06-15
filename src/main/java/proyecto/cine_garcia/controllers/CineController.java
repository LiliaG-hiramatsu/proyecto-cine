package proyecto.cine_garcia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.cine_garcia.entities.Cine;
import proyecto.cine_garcia.entities.Funcion;
import proyecto.cine_garcia.entities.Pelicula;
import proyecto.cine_garcia.services.CineService;
import proyecto.cine_garcia.services.CineServiceImpl;
import proyecto.cine_garcia.services.PeliculaService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/cines")
public class CineController extends BaseControllerImpl<Cine, CineServiceImpl> {

    @Autowired
    private CineService cineService;

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/{cine_id}/peliculas")
    public ResponseEntity<List<Pelicula>> obtenerPeliculasPorCine(@PathVariable Integer cine_id) {
        try {
            List<Pelicula> peliculas = cineService.obtenerPeliculasPorCine(cine_id);
            return ResponseEntity.ok(peliculas);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{cine_id}/peliculas/{pelicula_id}/funciones")
    public ResponseEntity<List<Funcion>> obtenerFuncionesPorPelicula(@PathVariable Integer pelicula_id) {
        try {
            List<Funcion> funciones = peliculaService.obtenerFuncionesPorPelicula(pelicula_id);
            return  ResponseEntity.ok(funciones);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
