package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.marcacaodto.MarcacaoDto;
import estg.ipvc.proj2.dtos.marcacaodto.MarcacaoMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.*;
import estg.ipvc.proj2.repository.*;
import estg.ipvc.proj2.services.MarcacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class MarcacaoServiceImpl implements MarcacaoService {

    private final MarcacaoRepository marcacaoRepository;
    private final EstadoMarcacaoRepository estadoMarcacaoRepository;
    private final ClienteRepository clienteRepository;
    private final FaturaReciboRepository faturaReciboRepository;

    @Autowired
    public MarcacaoServiceImpl(
            MarcacaoRepository marcacaoRepository,
            EstadoMarcacaoRepository estadoMarcacaoRepository,
            ClienteRepository clienteRepository,
            FaturaReciboRepository faturaReciboRepository
    ) {
        this.marcacaoRepository = marcacaoRepository;
        this.estadoMarcacaoRepository = estadoMarcacaoRepository;
        this.clienteRepository = clienteRepository;
        this.faturaReciboRepository = faturaReciboRepository;
    }

    @Override
    public MarcacaoDto createMarcacao(MarcacaoDto dto) {

        EstadoMarcacao estado =
                estadoMarcacaoRepository.findById(dto.getIdEstadom())
                        .orElseThrow(() ->
                                new EntityNotFoundException("Estado não encontrado"));

        Cliente cliente =
                clienteRepository.findById(dto.getIdCliente())
                        .orElseThrow(() ->
                                new EntityNotFoundException("Cliente não encontrado"));

        Marcacao marcacao = MarcacaoMapper.toEntity(dto);

        marcacao.setIdEstadom(estado);
        marcacao.setIdCliente(cliente);

        if (dto.getIfFaturar() != null) {
            FaturaRecibo fr =
                    faturaReciboRepository.findById(dto.getIfFaturar())
                            .orElseThrow(() ->
                                    new EntityNotFoundException("Fatura Recibo não encontrada"));

            marcacao.setIfFaturar(fr);
        }

        return MarcacaoMapper.toDto(
                marcacaoRepository.save(marcacao)
        );
    }

    @Override
    public PageResponse<MarcacaoDto> getAllMarcacoes(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Marcacao> page =
                marcacaoRepository.findAll(pageable);

        return PageMapper.toPageResponse(
                page,
                MarcacaoMapper::toDto
        );
    }

    @Override
    public MarcacaoDto getMarcacaoById(int id) {

        Marcacao marcacao =
                marcacaoRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException("Marcação não encontrada"));

        return MarcacaoMapper.toDto(marcacao);
    }

    @Override
    public MarcacaoDto updateMarcacao(MarcacaoDto dto, int id) {

        Marcacao marcacao =
                marcacaoRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException("Marcação não encontrada"));

        marcacao.setDtMarc(dto.getDtMarc());
        marcacao.setDtFim(dto.getDtFim());
        marcacao.setDtCheckin(dto.getDtCheckin());
        marcacao.setDtCheckout(dto.getDtCheckout());
        marcacao.setValort(dto.getValort());

        return MarcacaoMapper.toDto(
                marcacaoRepository.save(marcacao)
        );
    }

    @Override
    public void deleteMarcacao(int id) {

        Marcacao marcacao =
                marcacaoRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException("Marcação não encontrada"));

        marcacaoRepository.delete(marcacao);
    }
}