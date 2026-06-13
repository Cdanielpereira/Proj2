package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.faturapagamentodto.*;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.*;
import estg.ipvc.proj2.repository.*;
import estg.ipvc.proj2.services.FaturaPagamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class FaturaPagamentoServiceImpl implements FaturaPagamentoService {

    private final FaturaPagamentoRepository repository;
    private final FuncionarioRepository funcionarioRepository;
    private final MetodoPagamentoRepository metodoRepository;

    @Autowired
    public FaturaPagamentoServiceImpl(
            FaturaPagamentoRepository repository,
            FuncionarioRepository funcionarioRepository,
            MetodoPagamentoRepository metodoRepository) {

        this.repository = repository;
        this.funcionarioRepository = funcionarioRepository;
        this.metodoRepository = metodoRepository;
    }

    @Override
    public FaturaPagamentoDto createFaturaPagamento(FaturaPagamentoDto dto) {

        Funcionario funcionario = funcionarioRepository.findById(dto.getIdFunc())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

        MetodoPagamento metodo = metodoRepository.findById(dto.getIdMetodo())
                .orElseThrow(() -> new EntityNotFoundException("Método de pagamento não encontrado"));

        FaturaPagamento entity = FaturaPagamentoMapper.toEntity(dto);

        entity.setIdFunc(funcionario);
        entity.setIdMetodo(metodo);

        return FaturaPagamentoMapper.toDto(
                repository.save(entity)
        );
    }

    @Override
    public PageResponse<FaturaPagamentoDto> getAllFaturaPagamentos(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        return PageMapper.toPageResponse(
                repository.findAll(pageable),
                FaturaPagamentoMapper::toDto
        );
    }

    @Override
    public FaturaPagamentoDto getFaturaPagamentoById(int id) {

        return FaturaPagamentoMapper.toDto(
                repository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Fatura não encontrada"))
        );
    }

    @Override
    public FaturaPagamentoDto updateFaturaPagamento(FaturaPagamentoDto dto, int id) {

        FaturaPagamento entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fatura não encontrada"));

        entity.setIban(dto.getIban());
        entity.setValorpago(dto.getValorpago());
        entity.setDtPag(dto.getDtPag());

        return FaturaPagamentoMapper.toDto(
                repository.save(entity)
        );
    }

    @Override
    public void deleteFaturaPagamento(int id) {

        FaturaPagamento entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fatura não encontrada"));

        repository.delete(entity);
    }
}