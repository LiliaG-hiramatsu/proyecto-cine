package proyecto.cine_garcia.services;

import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Funcion;
import proyecto.cine_garcia.repositories.FuncionRepository;

import java.util.List;

@Service
public class FuncionServiceImpl extends BaseServiceImpl<Funcion, Integer> implements FuncionService {
    private final FuncionRepository funcionRepository;

    public FuncionServiceImpl(FuncionRepository funcionRepository) {
        super(funcionRepository);
        this.funcionRepository = funcionRepository;
    }
}
