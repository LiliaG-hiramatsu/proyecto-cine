package proyecto.cine_garcia.services;

import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Sala;
import proyecto.cine_garcia.repositories.SalaRepository;

@Service
public class SalaServiceImpl extends BaseServiceImpl<Sala, Integer> implements SalaService {

    private final SalaRepository salaRepository;

    public SalaServiceImpl(SalaRepository salaRepository) {
        super(salaRepository);
        this.salaRepository = salaRepository;
    }
}
