package proyecto.cine_garcia.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.cine_garcia.entities.Sala;
import proyecto.cine_garcia.services.SalaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/salas")
public class SalaController extends BaseControllerImpl<Sala, SalaServiceImpl> {
}
