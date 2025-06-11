package proyecto.cine_garcia.services;

import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Cine;

import java.util.List;

@Service
public interface CineService extends BaseService<Cine, Integer> {
    List<Cine> search(String filtro) throws Exception;
}
