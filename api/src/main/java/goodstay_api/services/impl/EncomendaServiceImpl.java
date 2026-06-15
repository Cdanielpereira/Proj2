package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.encomendadto.EncomendaDto;
import goodstay_api.dtos.encomendadto.EncomendaMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.Encomenda;
import goodstay_api.model.Servico;
import goodstay_api.repository.EncomendaRepository;
import goodstay_api.repository.ServicoRepository;
import goodstay_api.services.EncomendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EncomendaServiceImpl implements EncomendaService {

    private final EncomendaRepository encomendaRepository;
    private final ServicoRepository servicoRepository;

    @Autowired
    public EncomendaServiceImpl(
            EncomendaRepository encomendaRepository,
            ServicoRepository servicoRepository
    ) {
        this.encomendaRepository = encomendaRepository;
        this.servicoRepository = servicoRepository;
    }

    @Override
    public EncomendaDto createEncomenda(EncomendaDto dto) {

        Servico servico = servicoRepository.findById(dto.getIdServico())
                .orElseThrow(() ->
                        new EntityNotFoundException("Serviço não encontrado"));

        Encomenda encomenda = EncomendaMapper.toEntity(dto);

        encomenda.setIdServico(servico);

        Encomenda saved = encomendaRepository.save(encomenda);

        return EncomendaMapper.toDto(saved);
    }

    @Override
    public PageResponse<EncomendaDto> getAllEncomendas(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Encomenda> encomendas = encomendaRepository.findAll(pageable);

        return PageMapper.toPageResponse(
                encomendas,
                EncomendaMapper::toDto
        );
    }

    @Override
    public EncomendaDto getEncomendaById(int id) {

        Encomenda encomenda = encomendaRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Encomenda não encontrada"));

        return EncomendaMapper.toDto(encomenda);
    }

    @Override
    public EncomendaDto updateEncomenda(EncomendaDto dto, int id) {

        Encomenda encomenda = encomendaRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Encomenda não encontrada"));

        encomenda.setValortotal(dto.getValortotal());

        if (dto.getIdServico() != null) {

            Servico servico = servicoRepository.findById(dto.getIdServico())
                    .orElseThrow(() ->
                            new EntityNotFoundException("Serviço não encontrado"));

            encomenda.setIdServico(servico);
        }

        Encomenda updated = encomendaRepository.save(encomenda);

        return EncomendaMapper.toDto(updated);
    }

    @Override
    public void deleteEncomenda(int id) {

        Encomenda encomenda = encomendaRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Encomenda não encontrada"));

        encomendaRepository.delete(encomenda);
    }
}