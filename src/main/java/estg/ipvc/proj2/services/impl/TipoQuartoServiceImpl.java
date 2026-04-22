package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.TipoQuarto;
import estg.ipvc.proj2.repository.TipoQuartoRepository;
import estg.ipvc.proj2.services.TipoQuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoQuartoServiceImpl implements TipoQuartoService {

    @Autowired
    private TipoQuartoRepository tipoQuartoRepository;

    public List<TipoQuarto> getAllTipos() {
        List<TipoQuarto> list = new ArrayList<>();
        for (TipoQuarto tipo : tipoQuartoRepository.findAll()) {
            list.add(tipo);
        }
        return list;
    }

    public Optional<TipoQuarto> getTipoById(Integer id) {
        return tipoQuartoRepository.findById(id);
    }

    public TipoQuarto createTipo(TipoQuarto tipo) {
        return tipoQuartoRepository.save(tipo);
    }

    public TipoQuarto updateTipo(Integer id, TipoQuarto tipo) {
        if (tipoQuartoRepository.existsById(id)) {
            tipo.setId(id);
            return tipoQuartoRepository.save(tipo);
        }
        return null;
    }

    public void deleteTipo(Integer id) {
        tipoQuartoRepository.deleteById(id);
    }

    public boolean tipoExists(Integer id) {
        return tipoQuartoRepository.existsById(id);
    }
}

