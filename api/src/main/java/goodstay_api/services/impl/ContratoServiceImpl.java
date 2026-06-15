package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.contratodto.ContratoDto;
import goodstay_api.dtos.contratodto.ContratoMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.Contrato;
import goodstay_api.model.EstadoContract;
import goodstay_api.model.Funcionario;
import goodstay_api.repository.ContratoRepository;
import goodstay_api.repository.EstadoContractRepository;
import goodstay_api.repository.FuncionarioRepository;
import goodstay_api.services.ContratoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ContratoServiceImpl implements ContratoService {

    private final ContratoRepository contratoRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final EstadoContractRepository estadoContractRepository;

    @Autowired
    public ContratoServiceImpl(
            ContratoRepository contratoRepository,
            FuncionarioRepository funcionarioRepository,
            EstadoContractRepository estadoContractRepository
    ) {
        this.contratoRepository = contratoRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.estadoContractRepository = estadoContractRepository;
    }

    @Override
    public ContratoDto createContrato(ContratoDto dto) {

        Funcionario funcionario = funcionarioRepository.findById(dto.getIdFunc())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

        EstadoContract estado = estadoContractRepository.findById(dto.getIdEstadoc())
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado"));

        Contrato contrato = ContratoMapper.toEntity(dto);

        contrato.setIdFunc(funcionario);
        contrato.setIdEstadoc(estado);

        Contrato saved = contratoRepository.save(contrato);

        return ContratoMapper.toDto(saved);
    }

    @Override
    public PageResponse<ContratoDto> getAllContratos(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Contrato> contratos =
                contratoRepository.findAll(pageable);

        return PageMapper.toPageResponse(contratos, ContratoMapper::toDto);
    }

    @Override
    public ContratoDto getContratoById(int id) {

        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Contrato não encontrado"));

        return ContratoMapper.toDto(contrato);
    }

    @Override
    public ContratoDto updateContrato(ContratoDto dto, int id) {

        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Contrato não encontrado"));

        contrato.setSalario(dto.getSalario());
        contrato.setDtCriado(dto.getDtCriado());
        contrato.setDtAssinado(dto.getDtAssinado());
        contrato.setDtIni(dto.getDtIni());
        contrato.setDtFim(dto.getDtFim());

        Contrato updated = contratoRepository.save(contrato);

        return ContratoMapper.toDto(updated);
    }

    @Override
    public void deleteContratoId(int id) {

        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Contrato não encontrado"));

        contratoRepository.delete(contrato);
    }
}