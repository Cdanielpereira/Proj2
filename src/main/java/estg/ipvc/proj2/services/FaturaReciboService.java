package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.FaturaRecibo;
import estg.ipvc.proj2.repository.FaturaReciboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FaturaReciboService {
    @Autowired
    private FaturaReciboRepository faturaReciboRepository;

    public List<FaturaRecibo> getAllFaturas() {
        List<FaturaRecibo> list = new ArrayList<>();
        for (FaturaRecibo fatura : faturaReciboRepository.findAll())
        {
            list.add(fatura);
        }
        return list;
    }
    public Optional<FaturaRecibo> getFaturaById(Integer id)
    {
        return faturaReciboRepository.findById(id);
    }

    public FaturaRecibo createFatura(FaturaRecibo fatura)
    {
        return faturaReciboRepository.save(fatura);
    }

    public FaturaRecibo updateFatura(Integer id, FaturaRecibo fatura)
    {
        if (faturaReciboRepository.existsById(id))
        {
            fatura.setId(id);
            return faturaReciboRepository.save(fatura);
        }
        return null;
    }
    public void deleteFatura(Integer id) {faturaReciboRepository.deleteById(id);}

    public boolean faturaExists(Integer id) {return faturaReciboRepository.existsById(id);}
}

