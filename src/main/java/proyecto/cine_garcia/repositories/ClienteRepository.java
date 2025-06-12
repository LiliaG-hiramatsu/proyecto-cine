package proyecto.cine_garcia.repositories;

import org.springframework.stereotype.Repository;
import proyecto.cine_garcia.entities.Cliente;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Integer> {

    Cliente findByEmail(String email);
}
