package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.nacionalidadedto.NacionalidadeDto;
import goodstay_api.dtos.nacionalidadedto.NacionalidadeMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.Nacionalidade;
import goodstay_api.repository.NacionalidadeRepository;
import goodstay_api.services.NacionalidadeService;
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

        nacionalidade.setNacionalidade(dto.getNacionalidade());

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