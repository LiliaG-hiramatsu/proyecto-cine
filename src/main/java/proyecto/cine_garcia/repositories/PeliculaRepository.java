package proyecto.cine_garcia.repositories;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyecto.cine_garcia.entities.Pelicula;

import java.util.List;

@Repository
public interface PeliculaRepository extends BaseRepository<Pelicula, Integer> {

    List<Pelicula> findByGenero(String genero);
    List<Pelicula> findTituloContainingIgnoreCase(String titulo);
    List<Pelicula> findByFuncionesPorCineId(@Param("cine_id") Integer cine_id);
}
