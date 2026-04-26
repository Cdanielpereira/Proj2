package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.Cliente;
import estg.ipvc.proj2.repository.ClienteRepository;
import estg.ipvc.proj2.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() {
        List<Cliente> list = new ArrayList<>();
        clienteRepository.findAll().forEach(list::add);
        return list;
    }
    @Override
    public Optional<Cliente> getClienteById(Integer id) {return clienteRepository.findById(id);}

    @Override
    public Cliente createCliente(Cliente cliente) {return clienteRepository.save(cliente);}
    @Override
    public Cliente updateCliente(Integer id, Cliente cliente)
    {
        if (clienteRepository.existsById(id))
        {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        return null;
    }
    @Override
    public void deleteCliente(Integer id) {clienteRepository.deleteById(id);}

    @Override
    public boolean clienteExists(Integer id) {return clienteRepository.existsById(id);}
}
