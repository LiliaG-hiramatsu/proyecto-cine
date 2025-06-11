package proyecto.cine_garcia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Cine;
import proyecto.cine_garcia.repositories.BaseRepository;
import proyecto.cine_garcia.repositories.CineRepository;

import java.util.List;

@Service
public class CineServiceImpl extends BaseServiceImpl<Cine, Integer> implements CineService {
    @Autowired
    private CineRepository cineRepository;

    public CineServiceImpl(BaseRepository<Cine, Integer> baseRepository, CineRepository cineRepository) {
        super(baseRepository);
        this.cineRepository = cineRepository;
    }

    public List<Cine> search(String filtro) throws Exception {
        try {
            List<Cine> cines = cineRepository.searchNativo(filtro);
            return cines;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
