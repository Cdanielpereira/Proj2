package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.piscinadto.PiscinaDto;
import goodstay_api.dtos.piscinadto.PiscinaMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.Piscina;
import goodstay_api.model.Zona;
import goodstay_api.repository.PiscinaRepository;
import goodstay_api.repository.ZonaRepository;
import goodstay_api.services.PiscinaService;
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