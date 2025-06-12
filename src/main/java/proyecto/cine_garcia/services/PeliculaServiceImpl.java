package proyecto.cine_garcia.services;

import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Pelicula;
import proyecto.cine_garcia.repositories.PeliculaRepository;

import java.util.List;

@Service
public class PeliculaServiceImpl extends BaseServiceImpl<Pelicula, Integer> implements PeliculaService {
    private final PeliculaRepository peliculaRepository;

    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        super(peliculaRepository);
        this.peliculaRepository = peliculaRepository;
    }


    public List<Pelicula> findByCine(Integer cine_id) throws Exception {
        try {
            return peliculaRepository.findByFuncionesPorCineId((cine_id));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
