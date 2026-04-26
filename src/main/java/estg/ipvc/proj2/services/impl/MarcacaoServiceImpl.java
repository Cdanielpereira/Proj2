package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.Marcacao;
import estg.ipvc.proj2.repository.MarcacaoRepository;
import estg.ipvc.proj2.services.MarcacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MarcacaoServiceImpl implements MarcacaoService {
    @Autowired
    private MarcacaoRepository marcacaoRepository;

    public List<Marcacao> getAllMarcacoes()
    {
        List<Marcacao> list = new ArrayList<>();
        for (Marcacao marcacao : marcacaoRepository.findAll())
        {
            list.add(marcacao);
        }
        return list;
    }
    public Optional<Marcacao> getMarcacaoById(Integer id)
    {
        return marcacaoRepository.findById(id);
    }

    public Marcacao createMarcacao(Marcacao marcacao)
    {
        return marcacaoRepository.save(marcacao);
    }
    public Marcacao updateMarcacao(Integer id, Marcacao marcacao)
    {
        if (marcacaoRepository.existsById(id))
        {
            marcacao.setId(id);
            return marcacaoRepository.save(marcacao);
        }
        return null;
    }
    public void deleteMarcacao(Integer id) {marcacaoRepository.deleteById(id);}

    public boolean marcacaoExists(Integer id) {return marcacaoRepository.existsById(id);}
}

