package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.linhaencdto.LinhaEncDto;

public interface LinhaEncService {

    LinhaEncDto createLinhaEnc(LinhaEncDto linhaEncDto);

    PageResponse<LinhaEncDto> getAllLinhaEnc(int pageNo, int pageSize);

    LinhaEncDto getLinhaEncById(Integer idEnco, Integer idProduto);

    LinhaEncDto updateLinhaEnc(LinhaEncDto linhaEncDto, Integer idEnco, Integer idProduto);

    void deleteLinhaEnc(Integer idEnco, Integer idProduto);
}