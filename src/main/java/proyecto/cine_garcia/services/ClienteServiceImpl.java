package proyecto.cine_garcia.services;

import org.springframework.stereotype.Service;
import proyecto.cine_garcia.entities.Cliente;
import proyecto.cine_garcia.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Integer> implements ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        super(clienteRepository);
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente findByEmail(String email) throws Exception {
        try {
            return clienteRepository.findByEmail(email);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
