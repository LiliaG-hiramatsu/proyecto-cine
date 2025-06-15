package proyecto.cine_garcia.services;

import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Pago;
import proyecto.cine_garcia.repositories.PagoRepository;

@Service
public class PagoServiceImpl extends BaseServiceImpl<Pago, Integer> implements PagoService {

    private final PagoRepository pagoRepository;

    public PagoServiceImpl(PagoRepository pagoRepository) {
        super(pagoRepository);
        this.pagoRepository = pagoRepository;
    }
}
