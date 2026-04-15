package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.LinhaManu;
import estg.ipvc.proj2.model.LinhaManuId;
import estg.ipvc.proj2.repository.LinhaManuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LinhaManuService {
    @Autowired
    private LinhaManuRepository linhaManuRepository;

    public List<LinhaManu> getAllLinhas()
    {
        List<LinhaManu> list = new ArrayList<>();
        for (LinhaManu linha : linhaManuRepository.findAll())
        {
            list.add(linha);
        }
        return list;
    }
    public Optional<LinhaManu> getLinhaById(LinhaManuId id)
    {
        return linhaManuRepository.findById(id);
    }

    public LinhaManu createLinha(LinhaManu linha) {return linhaManuRepository.save(linha);}
    public LinhaManu updateLinha(LinhaManuId id, LinhaManu linha)
    {
        if (linhaManuRepository.existsById(id))
        {
            linha.setId(id);
            return linhaManuRepository.save(linha);
        }
        return null;
    }
    public void deleteLinha(LinhaManuId id) {linhaManuRepository.deleteById(id);}

    public boolean linhaExists(LinhaManuId id) {return linhaManuRepository.existsById(id);}
}

