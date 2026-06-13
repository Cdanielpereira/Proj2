package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.cpostaldto.CpostalDto;

public interface CpostalService {

    CpostalDto createCpostal(CpostalDto cpostalDto);

    PageResponse<CpostalDto> getAllCpostal(int pageNo, int pageSize);

    CpostalDto getCpostalById(String codPostal);

    CpostalDto updateCpostal(CpostalDto cpostalDto, String codPostal);

    void deleteCpostalId(String codPostal);
}