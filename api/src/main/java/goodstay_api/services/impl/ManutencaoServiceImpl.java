package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.manutencaodto.ManutencaoDto;
import goodstay_api.dtos.manutencaodto.ManutencaoMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.Manutencao;
import goodstay_api.model.TipoIVA;
import goodstay_api.model.Zona;
import goodstay_api.repository.ManutencaoRepository;
import goodstay_api.repository.TipoIVARepository;
import goodstay_api.repository.ZonaRepository;
import goodstay_api.services.ManutencaoService;

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