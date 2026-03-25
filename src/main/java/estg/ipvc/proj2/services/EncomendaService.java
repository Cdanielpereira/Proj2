package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.Encomenda;
import estg.ipvc.proj2.repository.EncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EncomendaService {

    @Autowired
    private EncomendaRepository encomendaRepository;

    public List<Encomenda> getAllEncomendas() {
        List<Encomenda> list = new ArrayList<>();
        encomendaRepository.findAll().forEach(list::add);
        return list;
    }

    public Optional<Encomenda> getEncomendaById(Integer id) {
        return encomendaRepository.findById(id);
    }

    public Encomenda createEncomenda(Encomenda encomenda) {
        return encomendaRepository.save(encomenda);
    }

    public Encomenda updateEncomenda(Integer id, Encomenda encomenda) {
        if (encomendaRepository.existsById(id)) {
            encomenda.setId(id);
            return encomendaRepository.save(encomenda);
        }
        return null;
    }

    public void deleteEncomenda(Integer id) {
        encomendaRepository.deleteById(id);
    }

    public boolean encomendaExists(Integer id) {
        return encomendaRepository.existsById(id);
    }
}

