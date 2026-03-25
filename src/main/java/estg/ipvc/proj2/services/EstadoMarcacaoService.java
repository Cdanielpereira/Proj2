package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.EstadoMarcacao;
import estg.ipvc.proj2.repository.EstadoMarcacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoMarcacaoService {
    @Autowired
    private EstadoMarcacaoRepository estadoMarcacaoRepository;

    public List<EstadoMarcacao> getAllEstados()
    {
        List<EstadoMarcacao> list = new ArrayList<>();
        for (EstadoMarcacao estado : estadoMarcacaoRepository.findAll())
        {
            list.add(estado);
        }
        return list;
    }
    public Optional<EstadoMarcacao> getEstadoById(Integer id)
    {
        return estadoMarcacaoRepository.findById(id);
    }

    public EstadoMarcacao createEstado(EstadoMarcacao estado)
    {
        return estadoMarcacaoRepository.save(estado);
    }
    public EstadoMarcacao updateEstado(Integer id, EstadoMarcacao estado)
    {
        if (estadoMarcacaoRepository.existsById(id))
        {
            estado.setId(id);
            return estadoMarcacaoRepository.save(estado);
        }
        return null;
    }
    public void deleteEstado(Integer id) {estadoMarcacaoRepository.deleteById(id);}

    public boolean estadoExists(Integer id) {
        return estadoMarcacaoRepository.existsById(id);
    }
}

