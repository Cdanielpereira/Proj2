package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.manutencaodto.ManutencaoDto;
import estg.ipvc.proj2.dtos.manutencaodto.ManutencaoMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.Manutencao;
import estg.ipvc.proj2.model.TipoIVA;
import estg.ipvc.proj2.model.Zona;
import estg.ipvc.proj2.repository.ManutencaoRepository;
import estg.ipvc.proj2.repository.TipoIVARepository;
import estg.ipvc.proj2.repository.ZonaRepository;
import estg.ipvc.proj2.services.ManutencaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ManutencaoServiceImpl implements ManutencaoService {

    private final ManutencaoRepository manutencaoRepository;
    private final ZonaRepository zonaRepository;
    private final TipoIVARepository tipoIVARepository;

    @Autowired
    public ManutencaoServiceImpl(
            ManutencaoRepository manutencaoRepository,
            ZonaRepository zonaRepository,
            TipoIVARepository tipoIVARepository
    ) {
        this.manutencaoRepository = manutencaoRepository;
        this.zonaRepository = zonaRepository;
        this.tipoIVARepository = tipoIVARepository;
    }

    @Override
    public ManutencaoDto createManutencao(ManutencaoDto dto) {

        Zona zona = zonaRepository.findById(dto.getIdZona())
                .orElseThrow(() -> new EntityNotFoundException("Zona não encontrada"));

        TipoIVA iva = tipoIVARepository.findById(dto.getIdiva())
                .orElseThrow(() -> new EntityNotFoundException("IVA não encontrado"));

        Manutencao manutencao = ManutencaoMapper.toEntity(dto);

        manutencao.setIdZona(zona);
        manutencao.setIdiva(iva);

        return ManutencaoMapper.toDto(
                manutencaoRepository.save(manutencao)
        );
    }

    @Override
    public PageResponse<ManutencaoDto> getAllManutencao(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Manutencao> page = manutencaoRepository.findAll(pageable);

        return PageMapper.toPageResponse(page, ManutencaoMapper::toDto);
    }

    @Override
    public ManutencaoDto getManutencaoById(int id) {

        Manutencao manutencao = manutencaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Manutenção não encontrada"));

        return ManutencaoMapper.toDto(manutencao);
    }

    @Override
    public ManutencaoDto updateManutencao(ManutencaoDto dto, int id) {

        Manutencao manutencao = manutencaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Manutenção não encontrada"));

        manutencao.setDescricao(dto.getDescricao());

        if(dto.getIdZona() != null){
            Zona zona = zonaRepository.findById(dto.getIdZona())
                    .orElseThrow(() -> new EntityNotFoundException("Zona não encontrada"));

            manutencao.setIdZona(zona);
        }

        if(dto.getIdiva() != null){
            TipoIVA iva = tipoIVARepository.findById(dto.getIdiva())
                    .orElseThrow(() -> new EntityNotFoundException("IVA não encontrado"));

            manutencao.setIdiva(iva);
        }

        return ManutencaoMapper.toDto(
                manutencaoRepository.save(manutencao)
        );
    }

    @Override
    public void deleteManutencao(int id) {

        Manutencao manutencao = manutencaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Manutenção não encontrada"));

        manutencaoRepository.delete(manutencao);
    }
}