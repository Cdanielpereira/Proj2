package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.tipofuncdto.TipoFuncDto;
import goodstay_api.dtos.tipofuncdto.TipoFuncMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.TipoFunc;
import goodstay_api.repository.TipoFuncRepository;
import goodstay_api.services.TipoFuncService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class TipoFuncServiceImpl implements TipoFuncService {

    private final TipoFuncRepository repository;

    @Autowired
    public TipoFuncServiceImpl(TipoFuncRepository repository) {
        this.repository = repository;
    }

    @Override
    public TipoFuncDto createTipoFunc(TipoFuncDto dto) {

        TipoFunc entity = TipoFuncMapper.toEntity(dto);

        return TipoFuncMapper.toDto(
                repository.save(entity)
        );
    }

    @Override
    public PageResponse<TipoFuncDto> getAllTipoFunc(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<TipoFunc> page = repository.findAll(pageable);

        return PageMapper.toPageResponse(page, TipoFuncMapper::toDto);
    }

    @Override
    public TipoFuncDto getTipoFuncById(int id) {

        TipoFunc entity = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("TipoFunc não encontrado"));

        return TipoFuncMapper.toDto(entity);
    }

    @Override
    public TipoFuncDto updateTipoFunc(TipoFuncDto dto, int id) {

        TipoFunc entity = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("TipoFunc não encontrado"));

        entity.setType(dto.getType());

        return TipoFuncMapper.toDto(
                repository.save(entity)
        );
    }

    @Override
    public void deleteTipoFunc(int id) {

        TipoFunc entity = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("TipoFunc não encontrado"));

        repository.delete(entity);
    }
}