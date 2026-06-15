package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.funcionariodto.FuncionarioDto;

public interface FuncionarioService {

    FuncionarioDto createFuncionario(FuncionarioDto funcionarioDto);

    PageResponse<FuncionarioDto> getAllFuncionarios(int pageNo, int pageSize);

    FuncionarioDto getFuncionarioById(int id);

    FuncionarioDto updateFuncionario(FuncionarioDto funcionarioDto, int id);

    void deleteFuncionario(int id);
}