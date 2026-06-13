package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.nacionalidadedto.NacionalidadeDto;

public interface NacionalidadeService {

    NacionalidadeDto createNacionalidade(NacionalidadeDto dto);

    PageResponse<NacionalidadeDto> getAllNacionalidades(int pageNo, int pageSize);

    NacionalidadeDto getNacionalidadeById(int id);

    NacionalidadeDto updateNacionalidade(NacionalidadeDto dto, int id);

    void deleteNacionalidade(int id);
}