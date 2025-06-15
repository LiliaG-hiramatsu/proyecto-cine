package proyecto.cine_garcia.repositories;

import org.springframework.stereotype.Repository;
import proyecto.cine_garcia.entities.Pago;

@Repository
public interface PagoRepository extends BaseRepository<Pago, Integer> {
}
