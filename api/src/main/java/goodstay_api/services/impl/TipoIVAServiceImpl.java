package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.tipoIVAdto.TipoIVADto;
import goodstay_api.dtos.tipoIVAdto.TipoIVAMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.TipoIVA;
import goodstay_api.repository.TipoIVARepository;
import goodstay_api.services.TipoIVAService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class TipoIVAServiceImpl implements TipoIVAService {

    private final TipoIVARepository repository;

    @Autowired
    public TipoIVAServiceImpl(TipoIVARepository repository) {
        this.repository = repository;
    }

    @Override
    public TipoIVADto createTipoIVA(TipoIVADto dto) {

        TipoIVA entity = TipoIVAMapper.toEntity(dto);

        return TipoIVAMapper.toDto(
                repository.save(entity)
        );
    }

    @Override
    public PageResponse<TipoIVADto> getAllTipoIVA(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<TipoIVA> page = repository.findAll(pageable);

        return PageMapper.toPageResponse(page, TipoIVAMapper::toDto);
    }

    @Override
    public TipoIVADto getTipoIVAById(int id) {

        TipoIVA entity = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("IVA não encontrado"));

        return TipoIVAMapper.toDto(entity);
    }

    @Override
    public TipoIVADto updateTipoIVA(TipoIVADto dto, int id) {

        TipoIVA entity = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("IVA não encontrado"));

        entity.setType(dto.getType());
        entity.setValor(dto.getValor());

        return TipoIVAMapper.toDto(
                repository.save(entity)
        );
    }

    @Override
    public void deleteTipoIVA(int id) {

        TipoIVA entity = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("IVA não encontrado"));

        repository.delete(entity);
    }
}