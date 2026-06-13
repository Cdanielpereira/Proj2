package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.tipocolabdto.TipoColabDto;
import estg.ipvc.proj2.dtos.tipocolabdto.TipoColabMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.TipoColab;
import estg.ipvc.proj2.repository.TipoColabRepository;
import estg.ipvc.proj2.services.TipoColabService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TipoColabServiceImpl implements TipoColabService {

    private final TipoColabRepository repository;

    @Autowired
    public TipoColabServiceImpl(TipoColabRepository repository) {
        this.repository = repository;
    }

    @Override
    public TipoColabDto createTipoColab(TipoColabDto dto) {

        TipoColab entity = TipoColabMapper.toEntity(dto);

        return TipoColabMapper.toDto(
                repository.save(entity)
        );
    }

    @Override
    public PageResponse<TipoColabDto> getAllTipoColab(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<TipoColab> page = repository.findAll(pageable);

        return PageMapper.toPageResponse(page, TipoColabMapper::toDto);
    }

    @Override
    public TipoColabDto getTipoColabById(int id) {

        TipoColab entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo Colaborador não encontrado"));

        return TipoColabMapper.toDto(entity);
    }

    @Override
    public TipoColabDto updateTipoColab(TipoColabDto dto, int id) {

        TipoColab entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo Colaborador não encontrado"));

        entity.setType(dto.getType());

        return TipoColabMapper.toDto(
                repository.save(entity)
        );
    }

    @Override
    public void deleteTipoColab(int id) {

        TipoColab entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo Colaborador não encontrado"));

        repository.delete(entity);
    }
}