package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.linhaencdto.LinhaEncDto;
import goodstay_api.dtos.linhaencdto.LinhaEncMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.*;
import goodstay_api.repository.*;
import goodstay_api.model.Encomenda;
import goodstay_api.model.LinhaEnc;
import goodstay_api.model.LinhaEncId;
import goodstay_api.model.Produto;
import goodstay_api.repository.EncomendaRepository;
import goodstay_api.repository.LinhaEncRepository;
import goodstay_api.repository.ProdutoRepository;
import goodstay_api.services.LinhaEncService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class LinhaEncServiceImpl implements LinhaEncService {

    private final LinhaEncRepository linhaEncRepository;
    private final EncomendaRepository encomendaRepository;
    private final ProdutoRepository produtoRepository;

    @Autowired
    public LinhaEncServiceImpl(
            LinhaEncRepository linhaEncRepository,
            EncomendaRepository encomendaRepository,
            ProdutoRepository produtoRepository) {

        this.linhaEncRepository = linhaEncRepository;
        this.encomendaRepository = encomendaRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public LinhaEncDto createLinhaEnc(LinhaEncDto dto) {

        Encomenda encomenda = encomendaRepository.findById(dto.getIdEnco())
                .orElseThrow(() -> new EntityNotFoundException("Encomenda não encontrada"));

        Produto produto = produtoRepository.findById(dto.getIdProduto())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        LinhaEnc linha = LinhaEncMapper.toEntity(dto);

        LinhaEncId id = new LinhaEncId();
        id.setIdEnco(dto.getIdEnco());
        id.setIdProduto(dto.getIdProduto());

        linha.setId(id);
        linha.setIdEnco(encomenda);
        linha.setIdProduto(produto);

        return LinhaEncMapper.toDto(
                linhaEncRepository.save(linha)
        );
    }

    @Override
    public PageResponse<LinhaEncDto> getAllLinhaEnc(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<LinhaEnc> page = linhaEncRepository.findAll(pageable);

        return PageMapper.toPageResponse(page, LinhaEncMapper::toDto);
    }

    @Override
    public LinhaEncDto getLinhaEncById(Integer idEnco, Integer idProduto) {

        LinhaEncId id = new LinhaEncId(idEnco, idProduto);

        LinhaEnc linha = linhaEncRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Linha de encomenda não encontrada"));

        return LinhaEncMapper.toDto(linha);
    }

    @Override
    public LinhaEncDto updateLinhaEnc(LinhaEncDto dto, Integer idEnco, Integer idProduto) {

        LinhaEncId id = new LinhaEncId(idEnco, idProduto);

        LinhaEnc linha = linhaEncRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Linha de encomenda não encontrada"));

        linha.setPrecoatual(dto.getPrecoatual());
        linha.setQtd(dto.getQtd());
        linha.setIvaatual(dto.getIvaatual());

        return LinhaEncMapper.toDto(
                linhaEncRepository.save(linha)
        );
    }

    @Override
    public void deleteLinhaEnc(Integer idEnco, Integer idProduto) {

        LinhaEncId id = new LinhaEncId(idEnco, idProduto);

        LinhaEnc linha = linhaEncRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Linha de encomenda não encontrada"));

        linhaEncRepository.delete(linha);
    }
}