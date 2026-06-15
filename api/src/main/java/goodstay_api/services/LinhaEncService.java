package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.linhaencdto.LinhaEncDto;

public interface LinhaEncService {

    LinhaEncDto createLinhaEnc(LinhaEncDto linhaEncDto);

    PageResponse<LinhaEncDto> getAllLinhaEnc(int pageNo, int pageSize);

    LinhaEncDto getLinhaEncById(Integer idEnco, Integer idProduto);

    LinhaEncDto updateLinhaEnc(LinhaEncDto linhaEncDto, Integer idEnco, Integer idProduto);

    void deleteLinhaEnc(Integer idEnco, Integer idProduto);
}