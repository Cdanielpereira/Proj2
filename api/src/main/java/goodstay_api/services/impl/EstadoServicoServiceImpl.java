package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.estadoservicodto.EstadoServicoDto;
import goodstay_api.dtos.estadoservicodto.EstadoServicoMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.EstadoServico;
import goodstay_api.repository.EstadoServicoRepository;
import goodstay_api.services.EstadoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EstadoServicoServiceImpl implements EstadoServicoService {

    private final EstadoServicoRepository estadoServicoRepository;

    @Autowired
    public EstadoServicoServiceImpl(
            EstadoServicoRepository estadoServicoRepository
    ) {
        this.estadoServicoRepository = estadoServicoRepository;
    }

    @Override
    public EstadoServicoDto createEstadoServico(EstadoServicoDto dto) {

        EstadoServico estado = EstadoServicoMapper.toEntity(dto);

        return EstadoServicoMapper.toDto(
                estadoServicoRepository.save(estado)
        );
    }

    @Override
    public PageResponse<EstadoServicoDto> getAllEstadoServicos(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<EstadoServico> page =
                estadoServicoRepository.findAll(pageable);

        return PageMapper.toPageResponse(
                page,
                EstadoServicoMapper::toDto
        );
    }

    @Override
    public EstadoServicoDto getEstadoServicoById(int id) {

        EstadoServico estado = estadoServicoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Estado de serviço não encontrado"));

        return EstadoServicoMapper.toDto(estado);
    }

    @Override
    public EstadoServicoDto updateEstadoServico(EstadoServicoDto dto, int id) {

        EstadoServico estado = estadoServicoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Estado de serviço não encontrado"));

        estado.setState(dto.getState());

        return EstadoServicoMapper.toDto(
                estadoServicoRepository.save(estado)
        );
    }

    @Override
    public void deleteEstadoServico(int id) {

        EstadoServico estado = estadoServicoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Estado de serviço não encontrado"));

        estadoServicoRepository.delete(estado);
    }
}