package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.contratodto.ContratoDto;

public interface ContratoService {

    ContratoDto createContrato(ContratoDto contratoDto);

    PageResponse<ContratoDto> getAllContratos(int pageNo, int pageSize);

    ContratoDto getContratoById(int id);

    ContratoDto updateContrato(ContratoDto contratoDto, int id);

    void deleteContratoId(int id);
}