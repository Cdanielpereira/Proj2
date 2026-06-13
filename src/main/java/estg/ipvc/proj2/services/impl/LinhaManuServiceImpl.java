package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.linhamanudto.LinhaManuDto;
import estg.ipvc.proj2.dtos.linhamanudto.LinhaManuMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.*;
import estg.ipvc.proj2.repository.LinhaManuRepository;
import estg.ipvc.proj2.repository.ManutencaoRepository;
import estg.ipvc.proj2.repository.ServicoRepository;
import estg.ipvc.proj2.services.LinhaManuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class LinhaManuServiceImpl implements LinhaManuService {

    private final LinhaManuRepository linhaManuRepository;
    private final ManutencaoRepository manutencaoRepository;
    private final ServicoRepository servicoRepository;

    @Autowired
    public LinhaManuServiceImpl(
            LinhaManuRepository linhaManuRepository,
            ManutencaoRepository manutencaoRepository,
            ServicoRepository servicoRepository
    ) {
        this.linhaManuRepository = linhaManuRepository;
        this.manutencaoRepository = manutencaoRepository;
        this.servicoRepository = servicoRepository;
    }

    @Override
    public LinhaManuDto createLinhaManu(LinhaManuDto dto) {

        Manutencao manutencao = manutencaoRepository.findById(dto.getIdManu())
                .orElseThrow(() -> new EntityNotFoundException("Manutenção não encontrada"));

        Servico servico = servicoRepository.findById(dto.getIdServico())
                .orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado"));

        LinhaManu linha = LinhaManuMapper.toEntity(dto);

        linha.setIdManu(manutencao);
        linha.setIdServico(servico);

        return LinhaManuMapper.toDto(
                linhaManuRepository.save(linha)
        );
    }

    @Override
    public PageResponse<LinhaManuDto> getAllLinhaManu(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<LinhaManu> page = linhaManuRepository.findAll(pageable);

        return PageMapper.toPageResponse(page, LinhaManuMapper::toDto);
    }

    @Override
    public LinhaManuDto getLinhaManuById(Integer idManu, Integer idServico) {

        LinhaManuId id = new LinhaManuId(idManu, idServico);

        LinhaManu linha = linhaManuRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("LinhaManu não encontrada"));

        return LinhaManuMapper.toDto(linha);
    }

    @Override
    public LinhaManuDto updateLinhaManu(
            LinhaManuDto dto,
            Integer idManu,
            Integer idServico
    ) {

        LinhaManuId id = new LinhaManuId(idManu, idServico);

        LinhaManu linha = linhaManuRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("LinhaManu não encontrada"));

        linha.setPrecoatual(dto.getPrecoatual());
        linha.setIvaatual(dto.getIvaatual());

        return LinhaManuMapper.toDto(
                linhaManuRepository.save(linha)
        );
    }

    @Override
    public void deleteLinhaManu(
            Integer idManu,
            Integer idServico
    ) {

        LinhaManuId id = new LinhaManuId(idManu, idServico);

        LinhaManu linha = linhaManuRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("LinhaManu não encontrada"));

        linhaManuRepository.delete(linha);
    }
}