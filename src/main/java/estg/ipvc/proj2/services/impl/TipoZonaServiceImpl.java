package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.tipozonadto.TipoZonaDto;
import estg.ipvc.proj2.dtos.tipozonadto.TipoZonaMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.TipoZona;
import estg.ipvc.proj2.repository.TipoZonaRepository;
import estg.ipvc.proj2.services.TipoZonaService;

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