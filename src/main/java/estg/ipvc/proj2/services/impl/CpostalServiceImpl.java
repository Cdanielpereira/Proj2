package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.Cpostal;
import estg.ipvc.proj2.repository.CpostalRepository;
import estg.ipvc.proj2.services.CpostalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CpostalServiceImpl implements CpostalService {
    @Autowired
    private CpostalRepository cpostalRepository;

    public List<Cpostal> getAllCpostais()
    {
        List<Cpostal> list = new ArrayList<>();
        for (Cpostal cpostal : cpostalRepository.findAll())
        {
            list.add(cpostal);
        }
        return list;
    }
    public Optional<Cpostal> getCpostalByCodPostal(String codPostal)
    {
        return cpostalRepository.findByCodPostal(codPostal);
    }

    public Cpostal createCpostal(Cpostal cpostal) {return cpostalRepository.save(cpostal);}

    public Cpostal updateCpostal(String codPostal, Cpostal cpostal)
    {
        if (cpostalRepository.existsByCodPostal(codPostal))
        {
            cpostal.setCodPostal(codPostal);
            return cpostalRepository.save(cpostal);
        }
        return null;
    }

    public void deleteCpostal(String codPostal) {cpostalRepository.deleteById(codPostal);}

    public boolean cpostalExists(String codPostal)
    {
        return cpostalRepository.existsByCodPostal(codPostal);
    }
}

