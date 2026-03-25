package estg.ipvc.proj2.services;
import estg.ipvc.proj2.model.TipoZona;
import estg.ipvc.proj2.repository.TipoZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TipoZonaService {
    @Autowired
    private TipoZonaRepository tipoZonaRepository;
    public List<TipoZona> getAllTipos()
    {
        List<TipoZona> list = new ArrayList<>();
        for (TipoZona tipo : tipoZonaRepository.findAll())
        {
            list.add(tipo);
        }
        return list;
    }
    public Optional<TipoZona> getTipoById(Integer id)
    {
        return tipoZonaRepository.findById(id);
    }

    public TipoZona createTipo(TipoZona tipo) {return tipoZonaRepository.save(tipo);}
    public TipoZona updateTipo(Integer id, TipoZona tipo)
    {
        if (tipoZonaRepository.existsById(id))
        {
            tipo.setId(id);
            return tipoZonaRepository.save(tipo);
        }
        return null;
    }
    public void deleteTipo(Integer id) {tipoZonaRepository.deleteById(id);}

    public boolean tipoExists(Integer id) {return tipoZonaRepository.existsById(id);}
}
