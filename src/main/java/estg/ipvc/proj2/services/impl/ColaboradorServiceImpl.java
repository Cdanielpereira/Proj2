package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.colaboradordto.ColaboradorDto;
import estg.ipvc.proj2.dtos.colaboradordto.ColaboradorMapper;
import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.Colaborador;
import estg.ipvc.proj2.model.Cpostal;
import estg.ipvc.proj2.model.TipoColab;
import estg.ipvc.proj2.repository.ColaboradorRepository;
import estg.ipvc.proj2.repository.CpostalRepository;
import estg.ipvc.proj2.repository.TipoColabRepository;
import estg.ipvc.proj2.services.ColaboradorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;
    private final TipoColabRepository tipoColabRepository;
    private final CpostalRepository cpostalRepository;

    @Autowired
    public ColaboradorServiceImpl(
            ColaboradorRepository colaboradorRepository,
            TipoColabRepository tipoColabRepository,
            CpostalRepository cpostalRepository
    ) {
        this.colaboradorRepository = colaboradorRepository;
        this.tipoColabRepository = tipoColabRepository;
        this.cpostalRepository = cpostalRepository;
    }

    @Override
    public ColaboradorDto createColaborador(ColaboradorDto dto) {

        TipoColab tipoColab = tipoColabRepository.findById(dto.getIdTipocolab())
                .orElseThrow(() -> new EntityNotFoundException("Tipo de colaborador não encontrado"));

        Cpostal cpostal = cpostalRepository.findById(dto.getCodPostal())
                .orElseThrow(() -> new EntityNotFoundException("Código postal não encontrado"));

        Colaborador colaborador = ColaboradorMapper.toEntity(dto);

        colaborador.setIdTipocolab(tipoColab);
        colaborador.setCodPostal(cpostal);

        Colaborador saved = colaboradorRepository.save(colaborador);

        return ColaboradorMapper.toDto(saved);
    }

    @Override
    public PageResponse<ColaboradorDto> getAllColaboradores(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Colaborador> colaboradores =
                colaboradorRepository.findAll(pageable);

        return PageMapper.toPageResponse(colaboradores, ColaboradorMapper::toDto);
    }

    @Override
    public ColaboradorDto getColaboradorById(int id) {

        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Colaborador não encontrado"));

        return ColaboradorMapper.toDto(colaborador);
    }

    @Override
    public ColaboradorDto updateColaborador(ColaboradorDto dto, int id) {

        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Colaborador não encontrado"));

        colaborador.setNome(dto.getNome());
        colaborador.setTelefone(dto.getTelefone());
        colaborador.setEmail(dto.getEmail());
        colaborador.setRua(dto.getRua());
        colaborador.setNporta(dto.getNporta());
        colaborador.setIban(dto.getIban());

        Colaborador updated = colaboradorRepository.save(colaborador);

        return ColaboradorMapper.toDto(updated);
    }

    @Override
    public void deleteColaboradorId(int id) {

        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Colaborador não encontrado"));

        colaboradorRepository.delete(colaborador);
    }
}