package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.Contrato;
import estg.ipvc.proj2.repository.ContratoRepository;
import estg.ipvc.proj2.services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContratoServiceImpl implements ContratoService {
    @Autowired
    private ContratoRepository contratoRepository;

    public List<Contrato> getAllContratos()
    {
        List<Contrato> list = new ArrayList<>();
        contratoRepository.findAll().forEach(list::add);
        return list;
    }
    public Optional<Contrato> getContratoById(Integer id)
    {
        return contratoRepository.findById(id);
    }

    public Contrato createContrato(Contrato contrato)
    {
        return contratoRepository.save(contrato);
    }
    public Contrato updateContrato(Integer id, Contrato contrato)
    {
        if (contratoRepository.existsById(id))
        {
            contrato.setId(id);
            return contratoRepository.save(contrato);
        }
        return null;
    }
    public void deleteContrato(Integer id) {contratoRepository.deleteById(id);}

    public boolean contratoExists(Integer id) {return contratoRepository.existsById(id);}
}

