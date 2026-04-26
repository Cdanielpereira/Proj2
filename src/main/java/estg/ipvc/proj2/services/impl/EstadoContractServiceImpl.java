package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.EstadoContract;
import estg.ipvc.proj2.repository.EstadoContractRepository;
import estg.ipvc.proj2.services.EstadoContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoContractServiceImpl implements EstadoContractService {
    @Autowired
    private EstadoContractRepository estadoContractRepository;

    public List<EstadoContract> getAllEstados()
    {
        List<EstadoContract> list = new ArrayList<>();
        for (EstadoContract estado : estadoContractRepository.findAll())
        {
            list.add(estado);
        }
        return list;
    }
    public Optional<EstadoContract> getEstadoById(Integer id)
    {
        return estadoContractRepository.findById(id);
    }

    public EstadoContract createEstado(EstadoContract estado)
    {
        return estadoContractRepository.save(estado);
    }
    public EstadoContract updateEstado(Integer id, EstadoContract estado)
    {
        if (estadoContractRepository.existsById(id))
        {
            estado.setId(id);
            return estadoContractRepository.save(estado);
        }
        return null;
    }
    public void deleteEstado(Integer id) {estadoContractRepository.deleteById(id);}

    public boolean estadoExists(Integer id) {return estadoContractRepository.existsById(id);}
}

