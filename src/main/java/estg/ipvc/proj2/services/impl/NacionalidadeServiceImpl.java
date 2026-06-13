package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.nacionalidadedto.NacionalidadeDto;
import estg.ipvc.proj2.dtos.nacionalidadedto.NacionalidadeMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.Nacionalidade;
import estg.ipvc.proj2.repository.NacionalidadeRepository;
import estg.ipvc.proj2.services.NacionalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class NacionalidadeServiceImpl implements NacionalidadeService {

    private final NacionalidadeRepository nacionalidadeRepository;

    @Autowired
    public NacionalidadeServiceImpl(
            NacionalidadeRepository nacionalidadeRepository
    ) {
        this.nacionalidadeRepository = nacionalidadeRepository;
    }

    @Override
    public NacionalidadeDto createNacionalidade(NacionalidadeDto dto) {

        Nacionalidade nacionalidade =
                NacionalidadeMapper.toEntity(dto);

        return NacionalidadeMapper.toDto(
                nacionalidadeRepository.save(nacionalidade)
        );
    }

    @Override
    public PageResponse<NacionalidadeDto> getAllNacionalidades(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Nacionalidade> page =
                nacionalidadeRepository.findAll(pageable);

        return PageMapper.toPageResponse(
                page,
                NacionalidadeMapper::toDto
        );
    }

    @Override
    public NacionalidadeDto getNacionalidadeById(int id) {

        Nacionalidade nacionalidade =
                nacionalidadeRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException("Nacionalidade não encontrada"));

        return NacionalidadeMapper.toDto(nacionalidade);
    }

    @Override
    public NacionalidadeDto updateNacionalidade(NacionalidadeDto dto, int id) {

        Nacionalidade nacionalidade =
                nacionalidadeRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException("Nacionalidade não encontrada"));

        nacionalidade.setNacionalidade(dto.getState());

        return NacionalidadeMapper.toDto(
                nacionalidadeRepository.save(nacionalidade)
        );
    }

    @Override
    public void deleteNacionalidade(int id) {

        Nacionalidade nacionalidade =
                nacionalidadeRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException("Nacionalidade não encontrada"));

        nacionalidadeRepository.delete(nacionalidade);
    }
}