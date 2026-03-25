package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.Manutencao;
import estg.ipvc.proj2.repository.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManutencaoService {
    @Autowired
    private ManutencaoRepository manutencaoRepository;

    public List<Manutencao> getAllManutencoes()
    {
        List<Manutencao> list = new ArrayList<>();
        for (Manutencao manutencao : manutencaoRepository.findAll())
        {
            list.add(manutencao);
        }
        return list;
    }
    public Optional<Manutencao> getManutencaoById(Integer id)
    {
        return manutencaoRepository.findById(id);
    }

    public Manutencao createManutencao(Manutencao manutencao)
    {
        return manutencaoRepository.save(manutencao);
    }
    public Manutencao updateManutencao(Integer id, Manutencao manutencao)
    {
        if (manutencaoRepository.existsById(id))
        {
            manutencao.setId(id);
            return manutencaoRepository.save(manutencao);
        }
        return null;
    }
    public void deleteManutencao(Integer id) {manutencaoRepository.deleteById(id);}

    public boolean manutencaoExists(Integer id)
    {
        return manutencaoRepository.existsById(id);
    }
}

