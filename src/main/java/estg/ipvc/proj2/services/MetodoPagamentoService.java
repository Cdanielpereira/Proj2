package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.metodopagamentodto.MetodoPagamentoDto;

public interface MetodoPagamentoService {

    MetodoPagamentoDto createMetodoPagamento(MetodoPagamentoDto dto);

    PageResponse<MetodoPagamentoDto> getAllMetodoPagamento(int pageNo, int pageSize);

    MetodoPagamentoDto getMetodoPagamentoById(int id);

    MetodoPagamentoDto updateMetodoPagamento(MetodoPagamentoDto dto, int id);

    void deleteMetodoPagamento(int id);
}