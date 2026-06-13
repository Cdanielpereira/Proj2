package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.estadocontractdto.EstadoContractDto;
import estg.ipvc.proj2.dtos.estadocontractdto.EstadoContractMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.EstadoContract;
import estg.ipvc.proj2.repository.EstadoContractRepository;
import estg.ipvc.proj2.services.EstadoContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EstadoContractServiceImpl implements EstadoContractService {

    private final EstadoContractRepository estadoContractRepository;

    @Autowired
    public EstadoContractServiceImpl(
            EstadoContractRepository estadoContractRepository
    ) {
        this.estadoContractRepository = estadoContractRepository;
    }

    @Override
    public EstadoContractDto createEstadoContract(EstadoContractDto dto) {

        EstadoContract estado = EstadoContractMapper.toEntity(dto);

        return EstadoContractMapper.toDto(
                estadoContractRepository.save(estado)
        );
    }

    @Override
    public PageResponse<EstadoContractDto> getAllEstadoContracts(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<EstadoContract> page =
                estadoContractRepository.findAll(pageable);

        return PageMapper.toPageResponse(
                page,
                EstadoContractMapper::toDto
        );
    }

    @Override
    public EstadoContractDto getEstadoContractById(int id) {

        EstadoContract estado = estadoContractRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("EstadoContract não encontrado"));

        return EstadoContractMapper.toDto(estado);
    }

    @Override
    public EstadoContractDto updateEstadoContract(EstadoContractDto dto, int id) {

        EstadoContract estado = estadoContractRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("EstadoContract não encontrado"));

        estado.setState(dto.getState());

        return EstadoContractMapper.toDto(
                estadoContractRepository.save(estado)
        );
    }

    @Override
    public void deleteEstadoContract(int id) {

        EstadoContract estado = estadoContractRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("EstadoContract não encontrado"));

        estadoContractRepository.delete(estado);
    }
}