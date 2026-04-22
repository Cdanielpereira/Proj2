package estg.ipvc.proj2.services.impl;
import estg.ipvc.proj2.model.EstadoServico;
import estg.ipvc.proj2.repository.EstadoServicoRepository;
import estg.ipvc.proj2.services.EstadoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class EstadoServicoServiceImpl implements EstadoServicoService {
    @Autowired
    private EstadoServicoRepository estadoServicoRepository;

    public List<EstadoServico> getAllEstados()
    {
        List<EstadoServico> list = new ArrayList<>();
        for (EstadoServico estado : estadoServicoRepository.findAll())
        {
            list.add(estado);
        }
        return list;
    }
    public Optional<EstadoServico> getEstadoById(Integer id)
    {
        return estadoServicoRepository.findById(id);
    }

    public EstadoServico createEstado(EstadoServico estado)
    {
        return estadoServicoRepository.save(estado);
    }
    public EstadoServico updateEstado(Integer id, EstadoServico estado)
    {
        if (estadoServicoRepository.existsById(id))
        {
            estado.setId(id);
            return estadoServicoRepository.save(estado);
        }
        return null;
    }
    public void deleteEstado(Integer id)
    {
        estadoServicoRepository.deleteById(id);
    }

    public boolean estadoExists(Integer id)
    {
        return estadoServicoRepository.existsById(id);
    }
}
