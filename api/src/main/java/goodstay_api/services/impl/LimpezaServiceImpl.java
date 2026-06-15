package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.limpezadto.LimpezaDto;
import goodstay_api.dtos.limpezadto.LimpezaMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.Funcionario;
import goodstay_api.model.Limpeza;
import goodstay_api.model.LimpezaId;
import goodstay_api.model.Zona;
import goodstay_api.repository.FuncionarioRepository;
import goodstay_api.repository.LimpezaRepository;
import goodstay_api.repository.ZonaRepository;
import goodstay_api.services.LimpezaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class LimpezaServiceImpl implements LimpezaService {

    private final LimpezaRepository limpezaRepository;
    private final ZonaRepository zonaRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public LimpezaServiceImpl(
            LimpezaRepository limpezaRepository,
            ZonaRepository zonaRepository,
            FuncionarioRepository funcionarioRepository) {

        this.limpezaRepository = limpezaRepository;
        this.zonaRepository = zonaRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public LimpezaDto createLimpeza(LimpezaDto dto) {

        Zona zona = zonaRepository.findById(dto.getIdZona())
                .orElseThrow(() -> new EntityNotFoundException("Zona não encontrada"));

        Funcionario funcionario = funcionarioRepository.findById(dto.getIdFunc())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

        Limpeza limpeza = LimpezaMapper.toEntity(dto);

        LimpezaId id = new LimpezaId();
        id.setIdZona(dto.getIdZona());
        id.setIdFunc(dto.getIdFunc());

        limpeza.setId(id);
        limpeza.setIdZona(zona);
        limpeza.setIdFunc(funcionario);

        return LimpezaMapper.toDto(
                limpezaRepository.save(limpeza)
        );
    }

    @Override
    public PageResponse<LimpezaDto> getAllLimpezas(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Limpeza> page = limpezaRepository.findAll(pageable);

        return PageMapper.toPageResponse(page, LimpezaMapper::toDto);
    }

    @Override
    public LimpezaDto getLimpezaById(Integer idZona, Integer idFunc) {

        LimpezaId id = new LimpezaId();
        id.setIdZona(idZona);
        id.setIdFunc(idFunc);

        Limpeza limpeza = limpezaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Limpeza não encontrada"));

        return LimpezaMapper.toDto(limpeza);
    }

    @Override
    public LimpezaDto updateLimpeza(LimpezaDto dto, Integer idZona, Integer idFunc) {

        LimpezaId id = new LimpezaId();
        id.setIdZona(idZona);
        id.setIdFunc(idFunc);

        Limpeza limpeza = limpezaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Limpeza não encontrada"));

        limpeza.setDtReali(dto.getDtReali());

        return LimpezaMapper.toDto(
                limpezaRepository.save(limpeza)
        );
    }

    @Override
    public void deleteLimpeza(Integer idZona, Integer idFunc) {

        LimpezaId id = new LimpezaId();
        id.setIdZona(idZona);
        id.setIdFunc(idFunc);

        Limpeza limpeza = limpezaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Limpeza não encontrada"));

        limpezaRepository.delete(limpeza);
    }
}