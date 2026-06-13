package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.reservadto.ReservaDto;

public interface ReservaService {

    ReservaDto createReserva(ReservaDto dto);

    PageResponse<ReservaDto> getAllReservas(int pageNo, int pageSize);

    ReservaDto getReservaById(Integer idMarc, Integer nquarto);

    ReservaDto updateReserva(ReservaDto dto, Integer idMarc, Integer nquarto);

    void deleteReserva(Integer idMarc, Integer nquarto);
}