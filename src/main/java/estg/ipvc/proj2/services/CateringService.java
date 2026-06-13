package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.cateringdto.CateringDto;
import estg.ipvc.proj2.dtos.common.PageResponse;

public interface CateringService {

    CateringDto createCatering(CateringDto cateringDto);
    PageResponse<CateringDto> getAllCatering(int pageNo, int pageSize);
    CateringDto getCateringById(int id);
    CateringDto updateCatering(CateringDto cateringDto, int id);
    void deleteCateringId(int id);
}