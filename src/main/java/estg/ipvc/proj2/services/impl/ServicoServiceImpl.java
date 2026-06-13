package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.servicodto.ServicoDto;
import estg.ipvc.proj2.dtos.servicodto.ServicoMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.Colaborador;
import estg.ipvc.proj2.model.EstadoServico;
import estg.ipvc.proj2.model.Funcionario;
import estg.ipvc.proj2.model.Servico;
import estg.ipvc.proj2.repository.ColaboradorRepository;
import estg.ipvc.proj2.repository.EstadoServicoRepository;
import estg.ipvc.proj2.repository.FuncionarioRepository;
import estg.ipvc.proj2.repository.ServicoRepository;
import estg.ipvc.proj2.services.ServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServicoServiceImpl implements ServicoService {

    private final ServicoRepository servicoRepository;
    private final EstadoServicoRepository estadoServicoRepository;
    private final ColaboradorRepository colaboradorRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public ServicoServiceImpl(
            ServicoRepository servicoRepository,
            EstadoServicoRepository estadoServicoRepository,
            ColaboradorRepository colaboradorRepository,
            FuncionarioRepository funcionarioRepository) {

        this.servicoRepository = servicoRepository;
        this.estadoServicoRepository = estadoServicoRepository;
        this.colaboradorRepository = colaboradorRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public ServicoDto createServico(ServicoDto dto) {

        EstadoServico estado = estadoServicoRepository.findById(dto.getIdEstadoser())
                .orElseThrow(() -> new EntityNotFoundException("Estado Serviço não encontrado"));

        Colaborador colaborador = colaboradorRepository.findById(dto.getIdColab())
                .orElseThrow(() -> new EntityNotFoundException("Colaborador não encontrado"));

        Funcionario funcionario = funcionarioRepository.findById(dto.getIdFunc())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

        Servico servico = ServicoMapper.toEntity(dto);

        servico.setIdEstadoser(estado);
        servico.setIdColab(colaborador);
        servico.setIdFunc(funcionario);

        return ServicoMapper.toDto(
                servicoRepository.save(servico)
        );
    }

    @Override
    public PageResponse<ServicoDto> getAllServicos(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Servico> page = servicoRepository.findAll(pageable);

        return PageMapper.toPageResponse(page, ServicoMapper::toDto);
    }

    @Override
    public ServicoDto getServicoById(int id) {

        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado"));

        return ServicoMapper.toDto(servico);
    }

    @Override
    public ServicoDto updateServico(ServicoDto dto, int id) {

        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado"));

        servico.setValorpagar(dto.getValorpagar());
        servico.setDtMarc(dto.getDtMarc());
        servico.setDtRea(dto.getDtRea());
        servico.setIdFaturap(dto.getIdFaturap());

        return ServicoMapper.toDto(
                servicoRepository.save(servico)
        );
    }

    @Override
    public void deleteServico(int id) {

        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado"));

        servicoRepository.delete(servico);
    }
}