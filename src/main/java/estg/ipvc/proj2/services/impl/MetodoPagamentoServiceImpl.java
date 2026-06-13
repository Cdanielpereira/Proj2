package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.metodopagamentodto.MetodoPagamentoDto;
import estg.ipvc.proj2.dtos.metodopagamentodto.MetodoPagamentoMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.MetodoPagamento;
import estg.ipvc.proj2.repository.MetodoPagamentoRepository;
import estg.ipvc.proj2.services.MetodoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class MetodoPagamentoServiceImpl implements MetodoPagamentoService {

    private final MetodoPagamentoRepository metodoPagamentoRepository;

    @Autowired
    public MetodoPagamentoServiceImpl(
            MetodoPagamentoRepository metodoPagamentoRepository
    ) {
        this.metodoPagamentoRepository = metodoPagamentoRepository;
    }

    @Override
    public MetodoPagamentoDto createMetodoPagamento(MetodoPagamentoDto dto) {

        MetodoPagamento metodo = MetodoPagamentoMapper.toEntity(dto);

        return MetodoPagamentoMapper.toDto(
                metodoPagamentoRepository.save(metodo)
        );
    }

    @Override
    public PageResponse<MetodoPagamentoDto> getAllMetodoPagamento(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<MetodoPagamento> page =
                metodoPagamentoRepository.findAll(pageable);

        return PageMapper.toPageResponse(
                page,
                MetodoPagamentoMapper::toDto
        );
    }

    @Override
    public MetodoPagamentoDto getMetodoPagamentoById(int id) {

        MetodoPagamento metodo =
                metodoPagamentoRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException("Método de pagamento não encontrado"));

        return MetodoPagamentoMapper.toDto(metodo);
    }

    @Override
    public MetodoPagamentoDto updateMetodoPagamento(MetodoPagamentoDto dto, int id) {

        MetodoPagamento metodo =
                metodoPagamentoRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException("Método de pagamento não encontrado"));

        metodo.setMetodo(dto.getMetodo());

        return MetodoPagamentoMapper.toDto(
                metodoPagamentoRepository.save(metodo)
        );
    }

    @Override
    public void deleteMetodoPagamento(int id) {

        MetodoPagamento metodo =
                metodoPagamentoRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException("Método de pagamento não encontrado"));

        metodoPagamentoRepository.delete(metodo);
    }
}