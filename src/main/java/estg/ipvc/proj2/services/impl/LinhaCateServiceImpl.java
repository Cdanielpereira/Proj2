package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.LinhaCate;
import estg.ipvc.proj2.model.LinhaCateId;
import estg.ipvc.proj2.repository.LinhaCateRepository;
import estg.ipvc.proj2.services.LinhaCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LinhaCateServiceImpl implements LinhaCateService {
    @Autowired
    private LinhaCateRepository linhaCateRepository;

    public List<LinhaCate> getAllLinhas()
    {
        List<LinhaCate> list = new ArrayList<>();
        for (LinhaCate linha : linhaCateRepository.findAll())
        {
            list.add(linha);
        }
        return list;
    }
    public Optional<LinhaCate> getLinhaById(LinhaCateId id)
    {
        return linhaCateRepository.findById(id);
    }

    public LinhaCate createLinha(LinhaCate linha) {return linhaCateRepository.save(linha);}
    public LinhaCate updateLinha(LinhaCateId id, LinhaCate linha)
    {
        if (linhaCateRepository.existsById(id))
        {
            linha.setId(id);
            return linhaCateRepository.save(linha);
        }
        return null;
    }
    public void deleteLinha(LinhaCateId id) {linhaCateRepository.deleteById(id);}

    public boolean linhaExists(LinhaCateId id) {return linhaCateRepository.existsById(id);}
}

