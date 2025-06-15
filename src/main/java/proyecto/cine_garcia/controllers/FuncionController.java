package proyecto.cine_garcia.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.cine_garcia.entities.Funcion;
import proyecto.cine_garcia.services.FuncionServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/funciones")
public class FuncionController extends BaseControllerImpl<Funcion, FuncionServiceImpl> {
}
