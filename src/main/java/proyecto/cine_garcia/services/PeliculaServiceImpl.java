package proyecto.cine_garcia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Funcion;
import proyecto.cine_garcia.entities.Pelicula;
import proyecto.cine_garcia.repositories.FuncionRepository;
import proyecto.cine_garcia.repositories.PeliculaRepository;

import java.util.List;

@Service
public class PeliculaServiceImpl extends BaseServiceImpl<Pelicula, Integer> implements PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private FuncionRepository funcionRepository;

    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        super(peliculaRepository);
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public List<Funcion> obtenerFuncionesPorPelicula(Integer pelicula_id) {
        return funcionRepository.findByPeliculaId(pelicula_id);
    }
}
