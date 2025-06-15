package proyecto.cine_garcia.repositories;

import org.springframework.stereotype.Repository;
import proyecto.cine_garcia.entities.Venta;

import java.util.List;

@Repository
public interface VentaRepository extends BaseRepository<Venta, Integer> {
}
