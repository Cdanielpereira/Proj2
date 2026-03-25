package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.Quarto;
import estg.ipvc.proj2.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuartoService {
    @Autowired
    private QuartoRepository quartoRepository;

    public List<Quarto> getAllQuartos()
    {
        List<Quarto> list = new ArrayList<>();
        for (Quarto quarto : quartoRepository.findAll())
        {
            list.add(quarto);
        }
        return list;
    }
    public Optional<Quarto> getQuartoById(Integer id)
    {
        return quartoRepository.findById(id);
    }

    public Quarto createQuarto(Quarto quarto) {return quartoRepository.save(quarto);}
    public Quarto updateQuarto(Integer id, Quarto quarto)
    {
        if (quartoRepository.existsById(id))
        {
            quarto.setId(id);
            return quartoRepository.save(quarto);
        }
        return null;
    }
    public void deleteQuarto(Integer id) {quartoRepository.deleteById(id);}

    public boolean quartoExists(Integer id) {return quartoRepository.existsById(id);}
}

