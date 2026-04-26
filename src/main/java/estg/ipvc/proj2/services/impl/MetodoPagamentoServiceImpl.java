package estg.ipvc.proj2.services.impl;
import estg.ipvc.proj2.model.MetodoPagamento;
import estg.ipvc.proj2.repository.MetodoPagamentoRepository;
import estg.ipvc.proj2.services.MetodoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class MetodoPagamentoServiceImpl implements MetodoPagamentoService {
    @Autowired
    private MetodoPagamentoRepository metodoPagamentoRepository;
    public List<MetodoPagamento> getAllMetodos()
    {
        List<MetodoPagamento> list = new ArrayList<>();
        for (MetodoPagamento metodo : metodoPagamentoRepository.findAll())
        {
            list.add(metodo);
        }
        return list;
    }
    public Optional<MetodoPagamento> getMetodoById(Integer id)
    {
        return metodoPagamentoRepository.findById(id);
    }

    public MetodoPagamento createMetodo(MetodoPagamento metodo)
    {
        return metodoPagamentoRepository.save(metodo);
    }
    public MetodoPagamento updateMetodo(Integer id, MetodoPagamento metodo)
    {
        if (metodoPagamentoRepository.existsById(id))
        {
            metodo.setId(id);
            return metodoPagamentoRepository.save(metodo);
        }
        return null;
    }
    public void deleteMetodo(Integer id) {metodoPagamentoRepository.deleteById(id);}

    public boolean metodoExists(Integer id) {return metodoPagamentoRepository.existsById(id);}
}
