package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.faturapagamentodto.FaturaPagamentoDto;

public interface FaturaPagamentoService {

    FaturaPagamentoDto createFaturaPagamento(FaturaPagamentoDto dto);

    PageResponse<FaturaPagamentoDto> getAllFaturaPagamentos(int pageNo, int pageSize);

    FaturaPagamentoDto getFaturaPagamentoById(int id);

    FaturaPagamentoDto updateFaturaPagamento(FaturaPagamentoDto dto, int id);

    void deleteFaturaPagamento(int id);
}