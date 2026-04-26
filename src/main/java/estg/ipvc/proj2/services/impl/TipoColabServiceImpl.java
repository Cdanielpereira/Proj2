package estg.ipvc.proj2.services.impl;
import estg.ipvc.proj2.model.TipoColab;
import estg.ipvc.proj2.repository.TipoColabRepository;
import estg.ipvc.proj2.services.TipoColabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TipoColabServiceImpl implements TipoColabService {
    @Autowired
    private TipoColabRepository tipoColabRepository;
    public List<TipoColab> getAllTipos() {
        List<TipoColab> list = new ArrayList<>();
        for (TipoColab tipo : tipoColabRepository.findAll()) {
            list.add(tipo);
        }
        return list;
    }
    public Optional<TipoColab> getTipoById(Integer id)
    {
        return tipoColabRepository.findById(id);
    }

    public TipoColab createTipo(TipoColab tipo)
    {
        return tipoColabRepository.save(tipo);
    }
    public TipoColab updateTipo(Integer id, TipoColab tipo)
    {
        if (tipoColabRepository.existsById(id)) {
            tipo.setId(id);
            return tipoColabRepository.save(tipo);
        }
        return null;
    }
    public void deleteTipo(Integer id) {tipoColabRepository.deleteById(id);}

    public boolean tipoExists(Integer id) {return tipoColabRepository.existsById(id);}
}
