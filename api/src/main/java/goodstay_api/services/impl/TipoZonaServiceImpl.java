package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.tipozonadto.TipoZonaDto;
import goodstay_api.dtos.tipozonadto.TipoZonaMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.TipoZona;
import goodstay_api.repository.TipoZonaRepository;
import goodstay_api.services.TipoZonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class TipoZonaServiceImpl implements TipoZonaService {

    private final TipoZonaRepository repository;

    @Autowired
    public TipoZonaServiceImpl(TipoZonaRepository repository) {
        this.repository = repository;
    }

    @Override
    public TipoZonaDto createTipoZona(TipoZonaDto dto) {

        TipoZona entity = TipoZonaMapper.toEntity(dto);

        return TipoZonaMapper.toDto(
                repository.save(entity)
        );
    }

    @Override
    public PageResponse<TipoZonaDto> getAllTipoZona(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<TipoZona> page = repository.findAll(pageable);

        return PageMapper.toPageResponse(page, TipoZonaMapper::toDto);
    }

    @Override
    public TipoZonaDto getTipoZonaById(int id) {

        TipoZona entity = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("TipoZona não encontrado"));

        return TipoZonaMapper.toDto(entity);
    }

    @Override
    public TipoZonaDto updateTipoZona(TipoZonaDto dto, int id) {

        TipoZona entity = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("TipoZona não encontrado"));

        entity.setType(dto.getType());

        return TipoZonaMapper.toDto(
                repository.save(entity)
        );
    }

    @Override
    public void deleteTipoZona(int id) {

        TipoZona entity = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("TipoZona não encontrado"));

        repository.delete(entity);
    }
}