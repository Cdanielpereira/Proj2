package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.Zona;
import estg.ipvc.proj2.repository.ZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ZonaService {

    @Autowired
    private ZonaRepository zonaRepository;

    public List<Zona> getAllZonas() {
        List<Zona> list = new ArrayList<>();
        for (Zona zona : zonaRepository.findAll()) {
            list.add(zona);
        }
        return list;
    }

    public Optional<Zona> getZonaById(Integer id) {
        return zonaRepository.findById(id);
    }

    public Zona createZona(Zona zona) {
        return zonaRepository.save(zona);
    }

    public Zona updateZona(Integer id, Zona zona) {
        if (zonaRepository.existsById(id)) {
            zona.setIdZona(id);
            return zonaRepository.save(zona);
        }
        return null;
    }

    public void deleteZona(Integer id) {
        zonaRepository.deleteById(id);
    }

    public boolean zonaExists(Integer id) {
        return zonaRepository.existsById(id);
    }
}

