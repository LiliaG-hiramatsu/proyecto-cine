package proyecto.cine_garcia.repositories;

import org.springframework.stereotype.Repository;
import proyecto.cine_garcia.entities.Entrada;

import java.util.List;

@Repository
public interface EntradaRepository extends BaseRepository<Entrada, Integer> {

    // Entradas vendidas para una funcion
    List<Entrada> findByFuncionId(Integer funcion_id);
    // Entradas de un cliente
    List<Entrada> findByClienteId(Integer cliente_id);
}
