package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.contratodto.ContratoDto;

public interface ContratoService {

    ContratoDto createContrato(ContratoDto contratoDto);

    PageResponse<ContratoDto> getAllContratos(int pageNo, int pageSize);

    ContratoDto getContratoById(int id);

    ContratoDto updateContrato(ContratoDto contratoDto, int id);

    void deleteContratoId(int id);
}