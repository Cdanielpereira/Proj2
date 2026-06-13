package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.tipoquartodto.TipoQuartoDto;
import estg.ipvc.proj2.dtos.tipoquartodto.TipoQuartoMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.TipoQuarto;
import estg.ipvc.proj2.repository.TipoQuartoRepository;
import estg.ipvc.proj2.services.TipoQuartoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class TipoQuartoServiceImpl implements TipoQuartoService {

    private final TipoQuartoRepository repository;

    @Autowired
    public TipoQuartoServiceImpl(TipoQuartoRepository repository) {
        this.repository = repository;
    }

    @Override
    public TipoQuartoDto createTipoQuarto(TipoQuartoDto dto) {

        TipoQuarto entity = TipoQuartoMapper.toEntity(dto);

        return TipoQuartoMapper.toDto(
                repository.save(entity)
        );
    }

    @Override
    public PageResponse<TipoQuartoDto> getAllTipoQuarto(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<TipoQuarto> page = repository.findAll(pageable);

        return PageMapper.toPageResponse(page, TipoQuartoMapper::toDto);
    }

    @Override
    public TipoQuartoDto getTipoQuartoById(int id) {

        TipoQuarto entity = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("TipoQuarto não encontrado"));

        return TipoQuartoMapper.toDto(entity);
    }

    @Override
    public TipoQuartoDto updateTipoQuarto(TipoQuartoDto dto, int id) {

        TipoQuarto entity = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("TipoQuarto não encontrado"));

        entity.setType(dto.getType());

        return TipoQuartoMapper.toDto(
                repository.save(entity)
        );
    }

    @Override
    public void deleteTipoQuarto(int id) {

        TipoQuarto entity = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("TipoQuarto não encontrado"));

        repository.delete(entity);
    }
}