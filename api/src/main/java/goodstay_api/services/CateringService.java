package goodstay_api.services;

import goodstay_api.dtos.cateringdto.CateringDto;
import goodstay_api.dtos.common.PageResponse;

public interface CateringService {

    CateringDto createCatering(CateringDto cateringDto);
    PageResponse<CateringDto> getAllCatering(int pageNo, int pageSize);
    CateringDto getCateringById(int id);
    CateringDto updateCatering(CateringDto cateringDto, int id);
    void deleteCateringId(int id);
}