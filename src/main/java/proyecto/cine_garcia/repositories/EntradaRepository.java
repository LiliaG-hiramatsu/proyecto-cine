package proyecto.cine_garcia.repositories;

import org.springframework.stereotype.Repository;
import proyecto.cine_garcia.entities.Entrada;

import java.util.List;

@Repository
public interface EntradaRepository extends BaseRepository<Entrada, Integer> {
}
