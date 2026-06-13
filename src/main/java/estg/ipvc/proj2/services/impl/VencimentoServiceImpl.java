package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.vencimentodto.VencimentoDto;
import estg.ipvc.proj2.dtos.vencimentodto.VencimentoMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.Contrato;
import estg.ipvc.proj2.model.MetodoPagamento;
import estg.ipvc.proj2.model.Vencimento;
import estg.ipvc.proj2.repository.ContratoRepository;
import estg.ipvc.proj2.repository.MetodoPagamentoRepository;
import estg.ipvc.proj2.repository.VencimentoRepository;
import estg.ipvc.proj2.services.VencimentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class VencimentoServiceImpl implements VencimentoService {

    private final VencimentoRepository vencimentoRepository;
    private final ContratoRepository contratoRepository;
    private final MetodoPagamentoRepository metodoPagamentoRepository;

    @Autowired
    public VencimentoServiceImpl(
            VencimentoRepository vencimentoRepository,
            ContratoRepository contratoRepository,
            MetodoPagamentoRepository metodoPagamentoRepository) {

        this.vencimentoRepository = vencimentoRepository;
        this.contratoRepository = contratoRepository;
        this.metodoPagamentoRepository = metodoPagamentoRepository;
    }

    @Override
    public VencimentoDto createVencimento(VencimentoDto dto) {

        Contrato contrato = contratoRepository.findById(dto.getIdContrato())
                .orElseThrow(() ->
                        new EntityNotFoundException("Contrato não encontrado"));

        MetodoPagamento metodo = metodoPagamentoRepository.findById(dto.getIdMetodo())
                .orElseThrow(() ->
                        new EntityNotFoundException("Método de pagamento não encontrado"));

        Vencimento vencimento = VencimentoMapper.toEntity(dto);

        vencimento.setIdContrato(contrato);
        vencimento.setIdMetodo(metodo);

        return VencimentoMapper.toDto(
                vencimentoRepository.save(vencimento)
        );
    }

    @Override
    public PageResponse<VencimentoDto> getAllVencimentos(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Vencimento> page = vencimentoRepository.findAll(pageable);

        return PageMapper.toPageResponse(page, VencimentoMapper::toDto);
    }

    @Override
    public VencimentoDto getVencimentoById(int id) {

        Vencimento vencimento = vencimentoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Vencimento não encontrado"));

        return VencimentoMapper.toDto(vencimento);
    }

    @Override
    public VencimentoDto updateVencimento(VencimentoDto dto, int id) {

        Vencimento vencimento = vencimentoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Vencimento não encontrado"));

        vencimento.setValor(dto.getValor());
        vencimento.setDtPag(dto.getDtPag());
        vencimento.setMes(dto.getMes());
        vencimento.setPremio(dto.getPremio());
        vencimento.setIban(dto.getIban());

        if (dto.getIdContrato() != null) {

            Contrato contrato = contratoRepository.findById(dto.getIdContrato())
                    .orElseThrow(() ->
                            new EntityNotFoundException("Contrato não encontrado"));

            vencimento.setIdContrato(contrato);
        }

        if (dto.getIdMetodo() != null) {

            MetodoPagamento metodo = metodoPagamentoRepository.findById(dto.getIdMetodo())
                    .orElseThrow(() ->
                            new EntityNotFoundException("Método de pagamento não encontrado"));

            vencimento.setIdMetodo(metodo);
        }

        return VencimentoMapper.toDto(
                vencimentoRepository.save(vencimento)
        );
    }

    @Override
    public void deleteVencimento(int id) {

        Vencimento vencimento = vencimentoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Vencimento não encontrado"));

        vencimentoRepository.delete(vencimento);
    }
}