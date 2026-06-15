package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.faturapagamentodto.FaturaPagamentoDto;

public interface FaturaPagamentoService {

    FaturaPagamentoDto createFaturaPagamento(FaturaPagamentoDto dto);

    PageResponse<FaturaPagamentoDto> getAllFaturaPagamentos(int pageNo, int pageSize);

    FaturaPagamentoDto getFaturaPagamentoById(int id);

    FaturaPagamentoDto updateFaturaPagamento(FaturaPagamentoDto dto, int id);

    void deleteFaturaPagamento(int id);
}