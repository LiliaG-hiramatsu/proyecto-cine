package proyecto.cine_garcia.services;

import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Funcion;
import proyecto.cine_garcia.entities.Pelicula;

import java.util.List;

@Service
public interface PeliculaService extends BaseService<Pelicula, Integer> {
    List<Funcion> obtenerFuncionesPorPelicula(Integer pelicula_id);
}
