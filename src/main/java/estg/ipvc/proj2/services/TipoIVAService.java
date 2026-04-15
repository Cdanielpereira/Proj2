package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.TipoIVA;
import estg.ipvc.proj2.repository.TipoIVARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoIVAService {

    @Autowired
    private TipoIVARepository tipoIVARepository;

    public List<TipoIVA> getAllTipos() {
        List<TipoIVA> list = new ArrayList<>();
        for (TipoIVA tipo : tipoIVARepository.findAll()) {
            list.add(tipo);
        }
        return list;
    }

    public Optional<TipoIVA> getTipoById(Integer id) {
        return tipoIVARepository.findById(id);
    }

    public TipoIVA createTipo(TipoIVA tipo) {
        return tipoIVARepository.save(tipo);
    }

    public TipoIVA updateTipo(Integer id, TipoIVA tipo) {
        if (tipoIVARepository.existsById(id)) {
            tipo.setId(id);
            return tipoIVARepository.save(tipo);
        }
        return null;
    }

    public void deleteTipo(Integer id) {
        tipoIVARepository.deleteById(id);
    }

    public boolean tipoExists(Integer id) {
        return tipoIVARepository.existsById(id);
    }
}

