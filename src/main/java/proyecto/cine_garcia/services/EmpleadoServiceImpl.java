package proyecto.cine_garcia.services;

import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Empleado;
import proyecto.cine_garcia.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado, Integer> implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        super(empleadoRepository);
        this.empleadoRepository = empleadoRepository;
    }
}
