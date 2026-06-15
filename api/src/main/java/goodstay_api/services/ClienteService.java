package goodstay_api.services;

import goodstay_api.dtos.clientedto.ClienteDto;
import goodstay_api.dtos.common.PageResponse;

public interface ClienteService {

    ClienteDto createCliente(ClienteDto clienteDto);

    PageResponse<ClienteDto> getAllClientes(int pageNo, int pageSize);

    ClienteDto getClienteById(int id);

    ClienteDto updateCliente(ClienteDto clienteDto, int id);

    void deleteCliente(int id);
}