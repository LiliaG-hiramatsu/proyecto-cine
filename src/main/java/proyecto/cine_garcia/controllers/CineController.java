package proyecto.cine_garcia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.cine_garcia.entities.Cine;
import proyecto.cine_garcia.services.CineServiceImpl;
import proyecto.cine_garcia.services.PeliculaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/cines")
public class CineController extends BaseControllerImpl<Cine, CineServiceImpl> {

}
