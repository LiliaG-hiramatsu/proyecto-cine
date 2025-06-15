package proyecto.cine_garcia.services;

import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Venta;
import proyecto.cine_garcia.repositories.VentaRepository;

@Service
public class VentaServiceImpl extends BaseServiceImpl<Venta, Integer> implements VentaService {

    private final VentaRepository ventaRepository;

    public VentaServiceImpl(VentaRepository ventaRepository) {
        super(ventaRepository);
        this.ventaRepository = ventaRepository;
    }
}
