package proyecto.cine_garcia.controllers;

import org.springframework.web.bind.annotation.*;
import proyecto.cine_garcia.entities.Entrada;
import proyecto.cine_garcia.services.EntradaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/entradas")
public class EntradaController extends BaseControllerImpl<Entrada, EntradaServiceImpl> {
}
