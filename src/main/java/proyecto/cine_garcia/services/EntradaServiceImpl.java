package proyecto.cine_garcia.services;

import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Entrada;
import proyecto.cine_garcia.repositories.EntradaRepository;

@Service
public class EntradaServiceImpl extends BaseServiceImpl<Entrada, Integer> implements EntradaService {

    private final EntradaRepository entradaRepository;

    public EntradaServiceImpl(EntradaRepository entradaRepository) {
        super(entradaRepository);
        this.entradaRepository = entradaRepository;
    }
}
