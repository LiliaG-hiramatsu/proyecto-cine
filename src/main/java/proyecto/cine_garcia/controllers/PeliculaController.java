package proyecto.cine_garcia.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.cine_garcia.entities.Pelicula;
import proyecto.cine_garcia.services.PeliculaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/peliculas")
public class PeliculaController extends BaseControllerImpl<Pelicula, PeliculaServiceImpl> {
}
