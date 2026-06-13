package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.limpezadto.LimpezaDto;
import estg.ipvc.proj2.dtos.limpezadto.LimpezaMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.Funcionario;
import estg.ipvc.proj2.model.Limpeza;
import estg.ipvc.proj2.model.LimpezaId;
import estg.ipvc.proj2.model.Zona;
import estg.ipvc.proj2.repository.FuncionarioRepository;
import estg.ipvc.proj2.repository.LimpezaRepository;
import estg.ipvc.proj2.repository.ZonaRepository;
import estg.ipvc.proj2.services.LimpezaService;

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