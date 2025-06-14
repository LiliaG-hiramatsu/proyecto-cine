package proyecto.cine_garcia.repositories;

import org.springframework.stereotype.Repository;
import proyecto.cine_garcia.entities.Pelicula;

import java.util.List;

@Repository
public interface PeliculaRepository extends BaseRepository<Pelicula, Integer> {
}
