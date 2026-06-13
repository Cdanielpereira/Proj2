package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.tipoIVAdto.TipoIVADto;
import estg.ipvc.proj2.dtos.tipoIVAdto.TipoIVAMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.TipoIVA;
import estg.ipvc.proj2.repository.TipoIVARepository;
import estg.ipvc.proj2.services.TipoIVAService;

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

        entity.setType(dto.getDescricao());
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