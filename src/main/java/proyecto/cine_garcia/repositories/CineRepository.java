package proyecto.cine_garcia.repositories;

import org.springframework.stereotype.Repository;
import proyecto.cine_garcia.entities.Cine;

import java.util.List;

@Repository
public interface CineRepository extends BaseRepository<Cine, Integer> {
}
