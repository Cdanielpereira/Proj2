package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.zonadto.ZonaDto;
import estg.ipvc.proj2.dtos.zonadto.ZonaMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.TipoZona;
import estg.ipvc.proj2.model.Zona;
import estg.ipvc.proj2.repository.TipoZonaRepository;
import estg.ipvc.proj2.repository.ZonaRepository;
import estg.ipvc.proj2.services.ZonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ZonaServiceImpl implements ZonaService {

    private final ZonaRepository zonaRepository;
    private final TipoZonaRepository tipoZonaRepository;

    @Autowired
    public ZonaServiceImpl(
            ZonaRepository zonaRepository,
            TipoZonaRepository tipoZonaRepository) {

        this.zonaRepository = zonaRepository;
        this.tipoZonaRepository = tipoZonaRepository;
    }

    @Override
    public ZonaDto createZona(ZonaDto dto) {

        TipoZona tipoZona = tipoZonaRepository.findById(dto.getIdTipoz())
                .orElseThrow(() ->
                        new EntityNotFoundException("TipoZona não encontrado"));

        Zona zona = ZonaMapper.toEntity(dto);

        zona.setIdTipoz(tipoZona);

        return ZonaMapper.toDto(
                zonaRepository.save(zona)
        );
    }

    @Override
    public PageResponse<ZonaDto> getAllZonas(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Zona> page = zonaRepository.findAll(pageable);

        return PageMapper.toPageResponse(page, ZonaMapper::toDto);
    }

    @Override
    public ZonaDto getZonaById(int id) {

        Zona zona = zonaRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Zona não encontrada"));

        return ZonaMapper.toDto(zona);
    }

    @Override
    public ZonaDto updateZona(ZonaDto dto, int id) {

        Zona zona = zonaRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Zona não encontrada"));

        zona.setAndar(dto.getAndar());

        if (dto.getIdTipoz() != null) {

            TipoZona tipoZona = tipoZonaRepository.findById(dto.getIdTipoz())
                    .orElseThrow(() ->
                            new EntityNotFoundException("TipoZona não encontrado"));

            zona.setIdTipoz(tipoZona);
        }

        return ZonaMapper.toDto(
                zonaRepository.save(zona)
        );
    }

    @Override
    public void deleteZona(int id) {

        Zona zona = zonaRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Zona não encontrada"));

        zonaRepository.delete(zona);
    }
}