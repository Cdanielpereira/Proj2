package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.Catering;
import estg.ipvc.proj2.repository.CateringRepository;
import estg.ipvc.proj2.services.CateringService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CateringServiceImpl implements CateringService {
    //@Autowired
    private CateringRepository cateringRepository;

    public List<Catering> getAllCaterings()
    {
        List<Catering> list = new ArrayList<>();
        for (Catering catering : cateringRepository.findAll())
        {
            list.add(catering);
        }
        return list;
    }
    public Catering getCateringById(Integer id)
    {
        return cateringRepository.findById(id);
    }

    public Catering createCatering(Catering catering)
    {
        return cateringRepository.save(catering);
    }
    public Catering updateCatering(Integer id, Catering catering)
    {
        if (cateringRepository.existsById(id))
        {
            catering.setId(id);
            return cateringRepository.save(catering);
        }
        return null;
    }
    public void deleteCatering(Integer id) {cateringRepository.deleteById(id);}

    public boolean cateringExists(Integer id) {return cateringRepository.existsById(id);}
}

