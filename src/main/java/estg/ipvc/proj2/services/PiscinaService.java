package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.Piscina;
import estg.ipvc.proj2.repository.PiscinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PiscinaService {
    @Autowired
    private PiscinaRepository piscinaRepository;

    public List<Piscina> getAllPiscinas()
    {
        List<Piscina> list = new ArrayList<>();
        piscinaRepository.findAll().forEach(list::add);
        return list;
    }
    public Optional<Piscina> getPiscinaById(Integer id)
    {
        return piscinaRepository.findById(id);
    }

    public Piscina createPiscina(Piscina piscina) {return piscinaRepository.save(piscina);}
    public Piscina updatePiscina(Integer id, Piscina piscina)
    {
        if (piscinaRepository.existsById(id))
        {
            piscina.setId(id);
            return piscinaRepository.save(piscina);
        }
        return null;
    }
    public void deletePiscina(Integer id) {piscinaRepository.deleteById(id);}

    public boolean piscinaExists(Integer id) {return piscinaRepository.existsById(id);}
}

