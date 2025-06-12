package proyecto.cine_garcia.controllers;

import org.springframework.web.bind.annotation.*;
import proyecto.cine_garcia.entities.Cine;
import proyecto.cine_garcia.services.CineServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/cines")
public class CineController extends BaseControllerImpl<Cine, CineServiceImpl> {
}
