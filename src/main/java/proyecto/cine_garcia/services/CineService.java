package proyecto.cine_garcia.services;

import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Cine;
import proyecto.cine_garcia.entities.Pelicula;

import java.util.List;

@Service
public interface CineService extends BaseService<Cine, Integer> {
    List<Pelicula> obtenerPeliculasPorCine(Integer cine_id);
}
