package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.Catering;
import estg.ipvc.proj2.repository.CateringRepository;
import estg.ipvc.proj2.services.CateringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CateringServiceImpl implements CateringService {
    //@Autowired
    private CateringRepository cateringRepository;

    @Autowired
    public CateringServiceImpl(CateringRepository cateringRepository) {
        this.cateringRepository = cateringRepository;
    }

    @Override
    public CateringDto createPokemon(CateringDto cateringDto) {
        Catering pokemon = new Catering();
        pokemon.setName(cateringDto.getName());
        pokemon.setType(cateringDto.getType());

        Catering newCatering = cateringRepository.save(catering);

        CateringDto cateringResponse = new CateringDto();
        cateringResponse.setId(newCatering.getId());
        cateringResponse.setName(newCatering.getName());
        cateringResponse.setType(newCatering.getType());
        return cateringResponse;
    }

    @Override
    public CateringResponse getAllCatering(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Catering> caterings = cateringRepository.findAll(pageable);
        List<Catering> listOfCaterings = caterings.getContent();
        List<CateringDto> content = listOfCaterings.stream().map(c -> mapToDto(c)).collect(Collectors.toList());

        CateringResponse pokemonResponse = new CateringResponse();
        cateringResponse.setContent(content);
        cateringResponse.setPageNo(caterings.getNumber());
        cateringResponse.setPageSize(caterings.getSize());
        cateringResponse.setTotalElements(caterings.getTotalElements());
        cateringResponse.setTotalPages(caterings.getTotalPages());
        cateringResponse.setLast(caterings.isLast());

        return pokemonResponse;
    }

    @Override
    public CateringDto getCateringById(int id) {
        Catering catering = cateringRepository.findById(id).orElseThrow(() -> new CateringNotFoundException("Catering could not be found"));
        return mapToDto(catering);
    }

    @Override
    public CateringDto updateCatering(Catering cateringDto, int id) {
        Catering catering = cateringRepository.findById(id).orElseThrow(() -> new CateringNotFoundException("Catering could not be updated"));

        catering.setName(cateringDto.getName());
        catering.setType(cateringDto.getType());

        Catering updatedCatering = cateringRepository.save(catering);
        return mapToDto(updatedCatering);
    }

    @Override
    public void deleteCateringId(int id) {
        Catering catering = cateringRepository.findById(id).orElseThrow(() -> new CateringNotFoundException("Catering could not be delete"));
        cateringRepository.delete(catering);
    }

    private CateringDto mapToDto(Catering catering) {
        CateringDto cateringDto = new CateringDto();
        cateringDto.setId(catering.getId());
        cateringDto.setName(catering.getName());
        cateringDto.setType(catering.getType());
        return cateringDto;
    }

    private Catering mapToEntity(CateringDto cateringDto) {
        Catering catering = new Catering();
        catering.setName(cateringDto.getName());
        catering.setType(cateringDto.getType());
        return catering;
    }
}

