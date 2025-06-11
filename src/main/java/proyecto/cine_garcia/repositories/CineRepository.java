package proyecto.cine_garcia.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyecto.cine_garcia.entities.Cine;

import java.util.List;

@Repository
public interface CineRepository extends BaseRepository<Cine, Integer> {
    // Anotacion Query Native
    @Query(
            value = "SELECT * FROM cine WHERE cine.nombre LIKE %:filtro%",
            nativeQuery = true
    )
    List<Cine> searchNativo(@Param("filtro") String filtro);

}
