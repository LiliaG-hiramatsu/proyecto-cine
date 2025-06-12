package proyecto.cine_garcia.services;

import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Funcion;

import java.util.List;

@Service
public interface FuncionService extends BaseService<Funcion, Integer> {
    List<Funcion> obtenerFuncionesPorPelicula(Integer id) throws Exception;
}
