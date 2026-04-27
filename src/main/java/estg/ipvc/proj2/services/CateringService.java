package estg.ipvc.proj2.services;


public interface CateringService {

    CateringDto createCatering(CateringDto cateringDto);
    CateringResponse getAllCatering(int pageNo, int pageSize);
    CateringDto getCateringById(int id);
    CateringDto updateCatering(CateringDto cateringDto, int id);
    void deleteCateringId(int id);
}

