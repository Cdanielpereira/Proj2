package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.Limpeza;
import estg.ipvc.proj2.model.LimpezaId;
import estg.ipvc.proj2.repository.LimpezaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LimpezaService {
    @Autowired
    private LimpezaRepository limpezaRepository;

    public List<Limpeza> getAllLimpezas()
    {
        List<Limpeza> list = new ArrayList<>();
        for (Limpeza limpeza : limpezaRepository.findAll())
        {
            list.add(limpeza);
        }
        return list;
    }
    public Optional<Limpeza> getLimpezaById(LimpezaId id)
    {
        return limpezaRepository.findById(id);
    }

    public Limpeza createLimpeza(Limpeza limpeza)
    {
        return limpezaRepository.save(limpeza);
    }
    public Limpeza updateLimpeza(LimpezaId id, Limpeza limpeza)
    {
        if (limpezaRepository.existsById(id))
        {
            limpeza.setId(id);
            return limpezaRepository.save(limpeza);
        }
        return null;
    }
    public void deleteLimpeza(LimpezaId id) {limpezaRepository.deleteById(id);}

    public boolean limpezaExists(LimpezaId id) {return limpezaRepository.existsById(id);}
}

