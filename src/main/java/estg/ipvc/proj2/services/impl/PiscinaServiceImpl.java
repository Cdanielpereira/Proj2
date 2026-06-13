package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.piscinadto.PiscinaDto;
import estg.ipvc.proj2.dtos.piscinadto.PiscinaMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.Piscina;
import estg.ipvc.proj2.model.Zona;
import estg.ipvc.proj2.repository.PiscinaRepository;
import estg.ipvc.proj2.repository.ZonaRepository;
import estg.ipvc.proj2.services.PiscinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class PiscinaServiceImpl implements PiscinaService {

    private final PiscinaRepository piscinaRepository;
    private final ZonaRepository zonaRepository;

    @Autowired
    public PiscinaServiceImpl(
            PiscinaRepository piscinaRepository,
            ZonaRepository zonaRepository
    ) {
        this.piscinaRepository = piscinaRepository;
        this.zonaRepository = zonaRepository;
    }

    @Override
    public PiscinaDto createPiscina(PiscinaDto dto) {

        Piscina piscina = new Piscina();

        piscina.setPh(dto.getPh());
        piscina.setTemp(dto.getTemp());
        piscina.setVolume(dto.getVolume());
        piscina.setNivelCl(dto.getNivelCl());

        if (dto.getIdZona() != null) {
            Zona zona = zonaRepository.findById(dto.getIdZona())
                    .orElseThrow(() ->
                            new EntityNotFoundException("Zona não encontrada"));

            piscina.setIdZona(zona);
        }

        return PiscinaMapper.toDto(
                piscinaRepository.save(piscina)
        );
    }

    @Override
    public PageResponse<PiscinaDto> getAllPiscinas(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        return PageMapper.toPageResponse(
                piscinaRepository.findAll(pageable),
                PiscinaMapper::toDto
        );
    }

    @Override
    public PiscinaDto getPiscinaById(int id) {

        Piscina piscina = piscinaRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Piscina não encontrada"));

        return PiscinaMapper.toDto(piscina);
    }

    @Override
    public PiscinaDto updatePiscina(PiscinaDto dto, int id) {

        Piscina piscina = piscinaRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Piscina não encontrada"));

        piscina.setPh(dto.getPh());
        piscina.setTemp(dto.getTemp());
        piscina.setVolume(dto.getVolume());
        piscina.setNivelCl(dto.getNivelCl());

        return PiscinaMapper.toDto(
                piscinaRepository.save(piscina)
        );
    }

    @Override
    public void deletePiscina(int id) {

        Piscina piscina = piscinaRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Piscina não encontrada"));

        piscinaRepository.delete(piscina);
    }
}