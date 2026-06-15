package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.vencimentodto.VencimentoDto;
import goodstay_api.dtos.vencimentodto.VencimentoMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.Contrato;
import goodstay_api.model.MetodoPagamento;
import goodstay_api.model.Vencimento;
import goodstay_api.repository.ContratoRepository;
import goodstay_api.repository.MetodoPagamentoRepository;
import goodstay_api.repository.VencimentoRepository;
import goodstay_api.services.VencimentoService;

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