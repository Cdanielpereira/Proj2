package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.clientedto.ClienteDto;
import estg.ipvc.proj2.dtos.common.PageResponse;

public interface ClienteService {

    ClienteDto createCliente(ClienteDto clienteDto);

    PageResponse<ClienteDto> getAllClientes(int pageNo, int pageSize);

    ClienteDto getClienteById(int id);

    ClienteDto updateCliente(ClienteDto clienteDto, int id);

    void deleteCliente(int id);
}