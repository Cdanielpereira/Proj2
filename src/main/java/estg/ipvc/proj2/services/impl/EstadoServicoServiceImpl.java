package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.estadoservicodto.EstadoServicoDto;
import estg.ipvc.proj2.dtos.estadoservicodto.EstadoServicoMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.EstadoServico;
import estg.ipvc.proj2.repository.EstadoServicoRepository;
import estg.ipvc.proj2.services.EstadoServicoService;
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