package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.cpostaldto.CpostalDto;
import goodstay_api.dtos.cpostaldto.CpostalMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.Cpostal;
import goodstay_api.repository.CpostalRepository;
import goodstay_api.services.CpostalService;

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