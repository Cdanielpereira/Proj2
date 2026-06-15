package goodstay_api.services.impl;

import goodstay_api.dtos.clientedto.ClienteDto;
import goodstay_api.dtos.clientedto.ClienteMapper;
import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.Cliente;
import goodstay_api.repository.*;
import goodstay_api.repository.ClienteRepository;
import goodstay_api.repository.CpostalRepository;
import goodstay_api.repository.NacionalidadeRepository;
import goodstay_api.repository.UserRepository;
import goodstay_api.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final UserRepository userRepository;
    private final NacionalidadeRepository nacionalidadeRepository;
    private final CpostalRepository cpostalRepository;

    @Autowired
    public ClienteServiceImpl(
            ClienteRepository clienteRepository,
            UserRepository userRepository,
            NacionalidadeRepository nacionalidadeRepository,
            CpostalRepository cpostalRepository
    ) {
        this.clienteRepository = clienteRepository;
        this.userRepository = userRepository;
        this.nacionalidadeRepository = nacionalidadeRepository;
        this.cpostalRepository = cpostalRepository;
    }

    @Override
    public ClienteDto createCliente(ClienteDto dto) {

        Cliente cliente = ClienteMapper.toEntity(dto);

        if (dto.getIdUser() != null) {
            cliente.setIdUser(
                    userRepository.findById(dto.getIdUser())
                            .orElseThrow(() -> new EntityNotFoundException("User não encontrado"))
            );
        }

        if (dto.getIdNacional() != null) {
            cliente.setIdNacional(
                    nacionalidadeRepository.findById(dto.getIdNacional())
                            .orElseThrow(() -> new EntityNotFoundException("Nacionalidade não encontrada"))
            );
        }

        if (dto.getCodPostal() != null) {
            cliente.setCodPostal(
                    cpostalRepository.findById(dto.getCodPostal())
                            .orElseThrow(() -> new EntityNotFoundException("Código Postal não encontrado"))
            );
        }

        return ClienteMapper.toDto(clienteRepository.save(cliente));
    }

    @Override
    public PageResponse<ClienteDto> getAllClientes(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Cliente> clientes = clienteRepository.findAll(pageable);

        return PageMapper.toPageResponse(clientes, ClienteMapper::toDto);
    }

    @Override
    public ClienteDto getClienteById(int id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        return ClienteMapper.toDto(cliente);
    }

    @Override
    public ClienteDto updateCliente(ClienteDto dto, int id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setRua(dto.getRua());
        cliente.setPorta(dto.getPorta());
        cliente.setSexo(dto.getSexo());
        cliente.setDtNasc(dto.getDtNasc());
        cliente.setNif(dto.getNif());

        if (dto.getIdUser() != null) {
            cliente.setIdUser(
                    userRepository.findById(dto.getIdUser())
                            .orElseThrow(() -> new EntityNotFoundException("User não encontrado"))
            );
        }

        if (dto.getIdNacional() != null) {
            cliente.setIdNacional(
                    nacionalidadeRepository.findById(dto.getIdNacional())
                            .orElseThrow(() -> new EntityNotFoundException("Nacionalidade não encontrada"))
            );
        }

        if (dto.getCodPostal() != null) {
            cliente.setCodPostal(
                    cpostalRepository.findById(dto.getCodPostal())
                            .orElseThrow(() -> new EntityNotFoundException("Código Postal não encontrado"))
            );
        }

        return ClienteMapper.toDto(clienteRepository.save(cliente));
    }

    @Override
    public void deleteCliente(int id) {
        if (!clienteRepository.existsById(id)) {
            throw new EntityNotFoundException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}