package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.quartodto.QuartoDto;
import estg.ipvc.proj2.dtos.quartodto.QuartoMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.Quarto;
import estg.ipvc.proj2.model.TipoIVA;
import estg.ipvc.proj2.model.TipoQuarto;
import estg.ipvc.proj2.model.Zona;
import estg.ipvc.proj2.repository.QuartoRepository;
import estg.ipvc.proj2.repository.TipoIVARepository;
import estg.ipvc.proj2.repository.TipoQuartoRepository;
import estg.ipvc.proj2.repository.ZonaRepository;
import estg.ipvc.proj2.services.QuartoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class QuartoServiceImpl implements QuartoService {

    private final QuartoRepository quartoRepository;
    private final ZonaRepository zonaRepository;
    private final TipoQuartoRepository tipoQuartoRepository;
    private final TipoIVARepository tipoIVARepository;

    @Autowired
    public QuartoServiceImpl(
            QuartoRepository quartoRepository,
            ZonaRepository zonaRepository,
            TipoQuartoRepository tipoQuartoRepository,
            TipoIVARepository tipoIVARepository
    ) {
        this.quartoRepository = quartoRepository;
        this.zonaRepository = zonaRepository;
        this.tipoQuartoRepository = tipoQuartoRepository;
        this.tipoIVARepository = tipoIVARepository;
    }

    @Override
    public QuartoDto createQuarto(QuartoDto dto) {

        Zona zona = zonaRepository.findById(dto.getIdZona())
                .orElseThrow(() ->
                        new EntityNotFoundException("Zona não encontrada"));

        TipoQuarto tipoQuarto = tipoQuartoRepository.findById(dto.getIdTipoq())
                .orElseThrow(() ->
                        new EntityNotFoundException("Tipo de quarto não encontrado"));

        TipoIVA iva = tipoIVARepository.findById(dto.getIdTipoIVA())
                .orElseThrow(() ->
                        new EntityNotFoundException("IVA não encontrado"));

        Quarto quarto = QuartoMapper.toEntity(dto);

        quarto.setIdZona(zona);
        quarto.setIdTipoq(tipoQuarto);
        quarto.setIdiva(iva);

        return QuartoMapper.toDto(
                quartoRepository.save(quarto)
        );
    }

    @Override
    public PageResponse<QuartoDto> getAllQuartos(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        return PageMapper.toPageResponse(
                quartoRepository.findAll(pageable),
                QuartoMapper::toDto
        );
    }

    @Override
    public QuartoDto getQuartoById(int id) {

        Quarto quarto = quartoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Quarto não encontrado"));

        return QuartoMapper.toDto(quarto);
    }

    @Override
    public QuartoDto updateQuarto(QuartoDto dto, int id) {

        Quarto quarto = quartoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Quarto não encontrado"));

        QuartoMapper.updateEntityFromDto(dto, quarto);

        return QuartoMapper.toDto(
                quartoRepository.save(quarto)
        );
    }

    @Override
    public void deleteQuarto(int id) {

        Quarto quarto = quartoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Quarto não encontrado"));

        quartoRepository.delete(quarto);
    }
}