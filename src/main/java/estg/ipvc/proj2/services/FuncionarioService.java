package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.funcionariodto.FuncionarioDto;

public interface FuncionarioService {

    FuncionarioDto createFuncionario(FuncionarioDto funcionarioDto);

    PageResponse<FuncionarioDto> getAllFuncionarios(int pageNo, int pageSize);

    FuncionarioDto getFuncionarioById(int id);

    FuncionarioDto updateFuncionario(FuncionarioDto funcionarioDto, int id);

    void deleteFuncionario(int id);
}