package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.LinhaEnc;
import estg.ipvc.proj2.model.LinhaEncId;
import estg.ipvc.proj2.repository.LinhaEncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LinhaEncService {
    @Autowired
    private LinhaEncRepository linhaEncRepository;

    public List<LinhaEnc> getAllLinhas()
    {
        List<LinhaEnc> list = new ArrayList<>();
        for (LinhaEnc linha : linhaEncRepository.findAll())
        {
            list.add(linha);
        }
        return list;
    }
    public Optional<LinhaEnc> getLinhaById(LinhaEncId id)
    {
        return linhaEncRepository.findById(id);
    }

    public LinhaEnc createLinha(LinhaEnc linha) {return linhaEncRepository.save(linha);}
    public LinhaEnc updateLinha(LinhaEncId id, LinhaEnc linha)
    {
        if (linhaEncRepository.existsById(id))
        {
            linha.setId(id);
            return linhaEncRepository.save(linha);
        }
        return null;
    }
    public void deleteLinha(LinhaEncId id) {linhaEncRepository.deleteById(id);}

    public boolean linhaExists(LinhaEncId id) {return linhaEncRepository.existsById(id);}
}

