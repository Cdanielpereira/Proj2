package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.Nacionalidade;
import estg.ipvc.proj2.repository.NacionalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NacionalidadeService {

    @Autowired
    private NacionalidadeRepository nacionalidadeRepository;

    public List<Nacionalidade> getAllNacionalidades() {
        List<Nacionalidade> list = new ArrayList<>();
        for (Nacionalidade nacionalidade : nacionalidadeRepository.findAll()) {
            list.add(nacionalidade);
        }
        return list;
    }

    public Optional<Nacionalidade> getNacionalidadeById(Integer id) {
        return nacionalidadeRepository.findById(id);
    }

    public Nacionalidade createNacionalidade(Nacionalidade nacionalidade) {
        return nacionalidadeRepository.save(nacionalidade);
    }

    public Nacionalidade updateNacionalidade(Integer id, Nacionalidade nacionalidade) {
        if (nacionalidadeRepository.existsById(id)) {
            nacionalidade.setId(id);
            return nacionalidadeRepository.save(nacionalidade);
        }
        return null;
    }

    public void deleteNacionalidade(Integer id) {
        nacionalidadeRepository.deleteById(id);
    }

    public boolean nacionalidadeExists(Integer id) {
        return nacionalidadeRepository.existsById(id);
    }
}

