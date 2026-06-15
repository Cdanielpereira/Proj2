package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.estadomarcacaodto.EstadoMarcacaoDto;
import goodstay_api.dtos.estadomarcacaodto.EstadoMarcacaoMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.EstadoMarcacao;
import goodstay_api.repository.EstadoMarcacaoRepository;
import goodstay_api.services.EstadoMarcacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EstadoMarcacaoServiceImpl implements EstadoMarcacaoService {

    private final EstadoMarcacaoRepository estadoMarcacaoRepository;

    @Autowired
    public EstadoMarcacaoServiceImpl(
            EstadoMarcacaoRepository estadoMarcacaoRepository
    ) {
        this.estadoMarcacaoRepository = estadoMarcacaoRepository;
    }

    @Override
    public EstadoMarcacaoDto createEstadoMarcacao(EstadoMarcacaoDto dto) {

        EstadoMarcacao estado = EstadoMarcacaoMapper.toEntity(dto);

        return EstadoMarcacaoMapper.toDto(
                estadoMarcacaoRepository.save(estado)
        );
    }

    @Override
    public PageResponse<EstadoMarcacaoDto> getAllEstadoMarcacoes(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<EstadoMarcacao> page =
                estadoMarcacaoRepository.findAll(pageable);

        return PageMapper.toPageResponse(
                page,
                EstadoMarcacaoMapper::toDto
        );
    }

    @Override
    public EstadoMarcacaoDto getEstadoMarcacaoById(int id) {

        EstadoMarcacao estado = estadoMarcacaoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Estado de marcação não encontrado"));

        return EstadoMarcacaoMapper.toDto(estado);
    }

    @Override
    public EstadoMarcacaoDto updateEstadoMarcacao(EstadoMarcacaoDto dto, int id) {

        EstadoMarcacao estado = estadoMarcacaoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Estado de marcação não encontrado"));

        estado.setState(dto.getState());

        return EstadoMarcacaoMapper.toDto(
                estadoMarcacaoRepository.save(estado)
        );
    }

    @Override
    public void deleteEstadoMarcacao(int id) {

        EstadoMarcacao estado = estadoMarcacaoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Estado de marcação não encontrado"));

        estadoMarcacaoRepository.delete(estado);
    }
}