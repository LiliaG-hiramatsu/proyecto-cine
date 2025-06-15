package proyecto.cine_garcia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Entrada;
import proyecto.cine_garcia.repositories.EntradaRepository;

import java.util.List;

@Service
public class EntradaServiceImpl extends BaseServiceImpl<Entrada, Integer> implements EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    public EntradaServiceImpl(EntradaRepository entradaRepository) {
        super(entradaRepository);
        this.entradaRepository = entradaRepository;
    }

}
