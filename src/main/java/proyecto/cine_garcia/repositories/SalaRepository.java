package proyecto.cine_garcia.repositories;

import org.springframework.stereotype.Repository;
import proyecto.cine_garcia.entities.Sala;

@Repository
public interface SalaRepository extends BaseRepository<Sala, Integer> {

    // Para encontrar la sala de una funcion
    Sala findByFuncionesId(Integer funcion_id);
}
