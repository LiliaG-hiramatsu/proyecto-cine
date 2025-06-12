package proyecto.cine_garcia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Cine;
import proyecto.cine_garcia.repositories.BaseRepository;
import proyecto.cine_garcia.repositories.CineRepository;

import java.util.List;

@Service
public class CineServiceImpl extends BaseServiceImpl<Cine, Integer> implements CineService {

    private final CineRepository cineRepository;

    public CineServiceImpl(CineRepository cineRepository) {
        super(cineRepository);
        this.cineRepository = cineRepository;
    }
}
