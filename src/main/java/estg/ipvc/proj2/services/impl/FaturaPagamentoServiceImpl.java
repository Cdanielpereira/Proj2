package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.FaturaPagamento;
import estg.ipvc.proj2.repository.FaturaPagamentoRepository;
import estg.ipvc.proj2.services.FaturaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FaturaPagamentoServiceImpl implements FaturaPagamentoService {
    @Autowired
    private FaturaPagamentoRepository faturaPagamentoRepository;

    public List<FaturaPagamento> getAllFaturas()
    {
        List<FaturaPagamento> list = new ArrayList<>();
        for (FaturaPagamento fatura : faturaPagamentoRepository.findAll())
        {
            list.add(fatura);
        }
        return list;
    }
    public Optional<FaturaPagamento> getFaturaById(Integer id)
    {
        return faturaPagamentoRepository.findById(id);
    }

    public FaturaPagamento createFatura(FaturaPagamento fatura)
    {
        return faturaPagamentoRepository.save(fatura);
    }
    public FaturaPagamento updateFatura(Integer id, FaturaPagamento fatura)
    {
        if (faturaPagamentoRepository.existsById(id))
        {
            fatura.setId(id);
            return faturaPagamentoRepository.save(fatura);
        }
        return null;
    }
    public void deleteFatura(Integer id) {faturaPagamentoRepository.deleteById(id);}

    public boolean faturaExists(Integer id)
    {
        return faturaPagamentoRepository.existsById(id);
    }
}

