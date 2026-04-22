package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.Colaborador;
import estg.ipvc.proj2.repository.ColaboradorRepository;
import estg.ipvc.proj2.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List<Colaborador> getAllColaboradores()
    {
        List<Colaborador> list = new ArrayList<>();
        colaboradorRepository.findAll().forEach(list::add);
        return list;
    }

    public Optional<Colaborador> getColaboradorById(Integer id)
    {
        return colaboradorRepository.findById(id);
    }

    public Colaborador createColaborador(Colaborador colaborador)
    {
        return colaboradorRepository.save(colaborador);
    }

    public Colaborador updateColaborador(Integer id, Colaborador colaborador)
    {
        if (colaboradorRepository.existsById(id))
        {
            colaborador.setId(id);
            return colaboradorRepository.save(colaborador);
        }
        return null;
    }

    public void deleteColaborador(Integer id) {colaboradorRepository.deleteById(id);}

    public boolean colaboradorExists(Integer id)
    {
        return colaboradorRepository.existsById(id);
    }
}

