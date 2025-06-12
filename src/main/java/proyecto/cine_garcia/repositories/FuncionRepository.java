package proyecto.cine_garcia.repositories;

import org.springframework.stereotype.Repository;
import proyecto.cine_garcia.entities.Funcion;

import java.util.List;

@Repository
public interface FuncionRepository extends BaseRepository<Funcion, Integer> {

    List<Funcion> findByPeliculaId(Integer pelicula_id);
    List<Funcion> findByPeliculaTitulo(String titulo);
    List<Funcion> findBySalaCineId(Integer cine_id);
}
