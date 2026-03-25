package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.TipoFunc;
import estg.ipvc.proj2.repository.TipoFuncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoFuncService {

    @Autowired
    private TipoFuncRepository tipoFuncRepository;

    public List<TipoFunc> getAllTipos() {
        List<TipoFunc> list = new ArrayList<>();
        for (TipoFunc tipo : tipoFuncRepository.findAll()) {
            list.add(tipo);
        }
        return list;
    }

    public Optional<TipoFunc> getTipoById(Integer id) {
        return tipoFuncRepository.findById(id);
    }

    public TipoFunc createTipo(TipoFunc tipo) {
        return tipoFuncRepository.save(tipo);
    }

    public TipoFunc updateTipo(Integer id, TipoFunc tipo) {
        if (tipoFuncRepository.existsById(id)) {
            tipo.setIdTipoFunc(id);
            return tipoFuncRepository.save(tipo);
        }
        return null;
    }

    public void deleteTipo(Integer id) {
        tipoFuncRepository.deleteById(id);
    }

    public boolean tipoExists(Integer id) {
        return tipoFuncRepository.existsById(id);
    }
}

