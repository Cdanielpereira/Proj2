package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.Servico;
import estg.ipvc.proj2.repository.ServicoRepository;
import estg.ipvc.proj2.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> getAllServicos()
    {
        List<Servico> list = new ArrayList<>();
        servicoRepository.findAll().forEach(list::add);
        return list;
    }
    public Optional<Servico> getServicoById(Integer id)
    {
        return servicoRepository.findById(id);
    }

    public Servico createServico(Servico servico)
    {
        return servicoRepository.save(servico);
    }
    public Servico updateServico(Integer id, Servico servico)
    {
        if (servicoRepository.existsById(id))
        {
            servico.setId(id);
            return servicoRepository.save(servico);
        }
        return null;
    }
    public void deleteServico(Integer id) {servicoRepository.deleteById(id);}

    public boolean servicoExists(Integer id) {return servicoRepository.existsById(id);}
}