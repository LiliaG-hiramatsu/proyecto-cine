package proyecto.cine_garcia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Cine;
import proyecto.cine_garcia.entities.Pelicula;
import proyecto.cine_garcia.repositories.BaseRepository;
import proyecto.cine_garcia.repositories.CineRepository;
import proyecto.cine_garcia.repositories.PeliculaRepository;

import java.util.List;

@Service
public class CineServiceImpl extends BaseServiceImpl<Cine, Integer> implements CineService {

    @Autowired
    private CineRepository cineRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    public CineServiceImpl(CineRepository cineRepository) {
        super(cineRepository);
        this.cineRepository = cineRepository;
    }

    @Override
    public List<Pelicula> obtenerPeliculasPorCine(Integer cine_id) {
        return peliculaRepository.findByCineId(cine_id);
    }
}
