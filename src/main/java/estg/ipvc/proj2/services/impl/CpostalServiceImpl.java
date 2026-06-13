package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.cpostaldto.CpostalDto;
import estg.ipvc.proj2.dtos.cpostaldto.CpostalMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.Cpostal;
import estg.ipvc.proj2.repository.CpostalRepository;
import estg.ipvc.proj2.services.CpostalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class CpostalServiceImpl implements CpostalService {

    private final CpostalRepository cpostalRepository;

    @Autowired
    public CpostalServiceImpl(CpostalRepository cpostalRepository) {
        this.cpostalRepository = cpostalRepository;
    }

    @Override
    public CpostalDto createCpostal(CpostalDto dto) {

        Cpostal cpostal = CpostalMapper.toEntity(dto);

        return CpostalMapper.toDto(
                cpostalRepository.save(cpostal)
        );
    }

    @Override
    public PageResponse<CpostalDto> getAllCpostal(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Cpostal> cpostais =
                cpostalRepository.findAll(pageable);

        return PageMapper.toPageResponse(cpostais, CpostalMapper::toDto);
    }

    @Override
    public CpostalDto getCpostalById(String codPostal) {

        Cpostal cpostal = cpostalRepository.findById(codPostal)
                .orElseThrow(() ->
                        new EntityNotFoundException("Código postal não encontrado"));

        return CpostalMapper.toDto(cpostal);
    }

    @Override
    public CpostalDto updateCpostal(CpostalDto dto, String codPostal) {

        Cpostal cpostal = cpostalRepository.findById(codPostal)
                .orElseThrow(() ->
                        new EntityNotFoundException("Código postal não encontrado"));

        cpostal.setLocalidade(dto.getLocalidade());

        Cpostal updated = cpostalRepository.save(cpostal);

        return CpostalMapper.toDto(updated);
    }

    @Override
    public void deleteCpostalId(String codPostal) {

        Cpostal cpostal = cpostalRepository.findById(codPostal)
                .orElseThrow(() ->
                        new EntityNotFoundException("Código postal não encontrado"));

        cpostalRepository.delete(cpostal);
    }
}