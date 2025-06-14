package proyecto.cine_garcia.repositories;

import org.springframework.stereotype.Repository;
import proyecto.cine_garcia.entities.Empleado;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado, Integer> {
}
