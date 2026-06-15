package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.metodopagamentodto.MetodoPagamentoDto;

public interface MetodoPagamentoService {

    MetodoPagamentoDto createMetodoPagamento(MetodoPagamentoDto dto);

    PageResponse<MetodoPagamentoDto> getAllMetodoPagamento(int pageNo, int pageSize);

    MetodoPagamentoDto getMetodoPagamentoById(int id);

    MetodoPagamentoDto updateMetodoPagamento(MetodoPagamentoDto dto, int id);

    void deleteMetodoPagamento(int id);
}