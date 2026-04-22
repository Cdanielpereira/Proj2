package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.Vencimento;
import estg.ipvc.proj2.repository.VencimentoRepository;
import estg.ipvc.proj2.services.VencimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VencimentoServiceImpl implements VencimentoService {

    @Autowired
    private VencimentoRepository vencimentoRepository;

    public List<Vencimento> getAllVencimentos() {
        List<Vencimento> list = new ArrayList<>();
        for (Vencimento vencimento : vencimentoRepository.findAll()) {
            list.add(vencimento);
        }
        return list;
    }

    public Optional<Vencimento> getVencimentoById(Integer id) {
        return vencimentoRepository.findById(id);
    }

    public Vencimento createVencimento(Vencimento vencimento) {
        return vencimentoRepository.save(vencimento);
    }

    public Vencimento updateVencimento(Integer id, Vencimento vencimento) {
        if (vencimentoRepository.existsById(id)) {
            vencimento.setId(id);
            return vencimentoRepository.save(vencimento);
        }
        return null;
    }

    public void deleteVencimento(Integer id) {
        vencimentoRepository.deleteById(id);
    }

    public boolean vencimentoExists(Integer id) {
        return vencimentoRepository.existsById(id);
    }
}

