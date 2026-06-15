package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.faturarecibodto.*;
import goodstay_api.dtos.faturarecibodto.FaturaReciboDto;
import goodstay_api.dtos.faturarecibodto.FaturaReciboMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.*;
import goodstay_api.repository.*;
import goodstay_api.model.FaturaRecibo;
import goodstay_api.model.MetodoPagamento;
import goodstay_api.repository.FaturaReciboRepository;
import goodstay_api.repository.MetodoPagamentoRepository;
import goodstay_api.services.FaturaReciboService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class FaturaReciboServiceImpl implements FaturaReciboService {

    private final FaturaReciboRepository repository;
    private final MetodoPagamentoRepository metodoRepository;

    @Autowired
    public FaturaReciboServiceImpl(
            FaturaReciboRepository repository,
            MetodoPagamentoRepository metodoRepository) {

        this.repository = repository;
        this.metodoRepository = metodoRepository;
    }

    @Override
    public FaturaReciboDto createFaturaRecibo(FaturaReciboDto dto) {

        MetodoPagamento metodo = metodoRepository.findById(dto.getIdMetodo())
                .orElseThrow(() -> new EntityNotFoundException("Método de pagamento não encontrado"));

        FaturaRecibo entity = FaturaReciboMapper.toEntity(dto);

        entity.setIdMetodo(metodo);

        return FaturaReciboMapper.toDto(
                repository.save(entity)
        );
    }

    @Override
    public PageResponse<FaturaReciboDto> getAllFaturaRecibos(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        return PageMapper.toPageResponse(
                repository.findAll(pageable),
                FaturaReciboMapper::toDto
        );
    }

    @Override
    public FaturaReciboDto getFaturaReciboById(int id) {

        return FaturaReciboMapper.toDto(
                repository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Fatura Recibo não encontrada"))
        );
    }

    @Override
    public FaturaReciboDto updateFaturaRecibo(FaturaReciboDto dto, int id) {

        FaturaRecibo entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fatura Recibo não encontrada"));

        entity.setValor(dto.getValor());
        entity.setDtPagamento(dto.getDtPagamento());
        entity.setNif(dto.getNif());

        return FaturaReciboMapper.toDto(
                repository.save(entity)
        );
    }

    @Override
    public void deleteFaturaRecibo(int id) {

        FaturaRecibo entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fatura Recibo não encontrada"));

        repository.delete(entity);
    }
}