package goodstay_api.services.impl;

import goodstay_api.model.Catering;
import goodstay_api.model.Servico;
import goodstay_api.model.TipoIVA;
import goodstay_api.dtos.cateringdto.CateringDto;
import goodstay_api.dtos.cateringdto.CateringMapper;
import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.repository.CateringRepository;
import goodstay_api.repository.ServicoRepository;
import goodstay_api.repository.TipoIVARepository;
import goodstay_api.services.CateringService;
import goodstay_api.exceptions.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CateringServiceImpl implements CateringService {

    private final CateringRepository cateringRepository;
    private final ServicoRepository servicoRepository;
    private final TipoIVARepository tipoIVARepository;

    @Autowired
    public CateringServiceImpl(
            CateringRepository cateringRepository,
            ServicoRepository servicoRepository,
            TipoIVARepository tipoIVARepository
    ) {
        this.cateringRepository = cateringRepository;
        this.servicoRepository = servicoRepository;
        this.tipoIVARepository = tipoIVARepository;
    }

    @Override
    public CateringDto createCatering(CateringDto dto) {

        Servico servico = servicoRepository.findById(dto.getIdServico())
                .orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado"));

        // IVA do sistema (podes trocar por lógica configurável depois)
        TipoIVA ivaAtual = tipoIVARepository.findById(2) // exemplo: Catering IVA default
                .orElseThrow(() -> new EntityNotFoundException("IVA não encontrado"));

        Catering catering = CateringMapper.toEntity(dto);

        catering.setIdServico(servico);
        catering.setIdiva(ivaAtual);
        catering.setIvaAtual(ivaAtual.getValor());

        Catering saved = cateringRepository.save(catering);

        return CateringMapper.toDto(saved);
    }

    @Override
    public PageResponse<CateringDto> getAllCatering(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Catering> caterings = cateringRepository.findAll(pageable);

        return PageMapper.toPageResponse(caterings, CateringMapper::toDto);
    }

    @Override
    public CateringDto getCateringById(int id) {

        Catering catering = cateringRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Catering não encontrado"));

        return CateringMapper.toDto(catering);
    }

    @Override
    public CateringDto updateCatering(CateringDto dto, int id) {

        Catering catering = cateringRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Catering não encontrado"));

        catering.setNhospedes(dto.getNhospedes());
        catering.setPrecohosp(dto.getPrecohosp());

        // serviço só muda se permitires alteração
        if (dto.getIdServico() != null) {
            Servico servico = servicoRepository.findById(dto.getIdServico())
                    .orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado"));

            catering.setIdServico(servico);
        }

        // IVA NÃO deve ser alterado aqui (regra de negócio)
        // só muda globalmente no sistema

        Catering updated = cateringRepository.save(catering);

        return CateringMapper.toDto(updated);
    }

    @Override
    public void deleteCateringId(int id) {

        Catering catering = cateringRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Catering não encontrado"));

        cateringRepository.delete(catering);
    }
}