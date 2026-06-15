package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.reservadto.ReservaDto;

public interface ReservaService {

    ReservaDto createReserva(ReservaDto dto);

    PageResponse<ReservaDto> getAllReservas(int pageNo, int pageSize);

    ReservaDto getReservaById(Integer idMarc, Integer nquarto);

    ReservaDto updateReserva(ReservaDto dto, Integer idMarc, Integer nquarto);

    void deleteReserva(Integer idMarc, Integer nquarto);
}