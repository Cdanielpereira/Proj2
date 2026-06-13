package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.funcionariodto.FuncionarioDto;
import estg.ipvc.proj2.dtos.funcionariodto.FuncionarioMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.*;
import estg.ipvc.proj2.repository.*;
import estg.ipvc.proj2.services.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final UserRepository userRepository;
    private final TipoFuncRepository tipoFuncRepository;
    private final CpostalRepository cpostalRepository;
    private final NacionalidadeRepository nacionalidadeRepository;

    @Autowired
    public FuncionarioServiceImpl(
            FuncionarioRepository funcionarioRepository,
            UserRepository userRepository,
            TipoFuncRepository tipoFuncRepository,
            CpostalRepository cpostalRepository,
            NacionalidadeRepository nacionalidadeRepository) {

        this.funcionarioRepository = funcionarioRepository;
        this.userRepository = userRepository;
        this.tipoFuncRepository = tipoFuncRepository;
        this.cpostalRepository = cpostalRepository;
        this.nacionalidadeRepository = nacionalidadeRepository;
    }

    @Override
    public FuncionarioDto createFuncionario(FuncionarioDto dto) {

        User user = userRepository.findById(dto.getIdUser())
                .orElseThrow(() -> new EntityNotFoundException("User não encontrado"));

        TipoFunc tipoFunc = tipoFuncRepository.findById(dto.getIdTipofunc())
                .orElseThrow(() -> new EntityNotFoundException("TipoFunc não encontrado"));

        Cpostal cpostal = cpostalRepository.findById(dto.getCodPostal())
                .orElseThrow(() -> new EntityNotFoundException("Código Postal não encontrado"));

        Nacionalidade nacionalidade = nacionalidadeRepository.findById(dto.getIdNacional())
                .orElseThrow(() -> new EntityNotFoundException("Nacionalidade não encontrada"));

        Funcionario funcionario = FuncionarioMapper.toEntity(dto);

        funcionario.setIdUser(user);
        funcionario.setIdTipofunc(tipoFunc);
        funcionario.setCodPostal(cpostal);
        funcionario.setIdNacional(nacionalidade);

        return FuncionarioMapper.toDto(
                funcionarioRepository.save(funcionario)
        );
    }

    @Override
    public PageResponse<FuncionarioDto> getAllFuncionarios(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Funcionario> page = funcionarioRepository.findAll(pageable);

        return PageMapper.toPageResponse(page, FuncionarioMapper::toDto);
    }

    @Override
    public FuncionarioDto getFuncionarioById(int id) {

        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

        return FuncionarioMapper.toDto(funcionario);
    }

    @Override
    public FuncionarioDto updateFuncionario(FuncionarioDto dto, int id) {

        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

        funcionario.setIban(dto.getIban());
        funcionario.setNif(dto.getNif());
        funcionario.setRua(dto.getRua());
        funcionario.setPorta(dto.getPorta());
        funcionario.setDtNasc(dto.getDtNasc());
        funcionario.setSexo(dto.getSexo());
        funcionario.setNome(dto.getNome());
        funcionario.setEmail(dto.getEmail());

        return FuncionarioMapper.toDto(
                funcionarioRepository.save(funcionario)
        );
    }

    @Override
    public void deleteFuncionario(int id) {

        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

        funcionarioRepository.delete(funcionario);
    }
}