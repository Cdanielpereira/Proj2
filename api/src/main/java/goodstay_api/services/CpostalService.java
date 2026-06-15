package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.cpostaldto.CpostalDto;

public interface CpostalService {

    CpostalDto createCpostal(CpostalDto cpostalDto);

    PageResponse<CpostalDto> getAllCpostal(int pageNo, int pageSize);

    CpostalDto getCpostalById(String codPostal);

    CpostalDto updateCpostal(CpostalDto cpostalDto, String codPostal);

    void deleteCpostalId(String codPostal);
}