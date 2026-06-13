package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.produtodto.ProdutoDto;
import estg.ipvc.proj2.dtos.produtodto.ProdutoMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.Produto;
import estg.ipvc.proj2.model.TipoIVA;
import estg.ipvc.proj2.repository.ProdutoRepository;
import estg.ipvc.proj2.repository.TipoIVARepository;
import estg.ipvc.proj2.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final TipoIVARepository tipoIVARepository;

    @Autowired
    public ProdutoServiceImpl(
            ProdutoRepository produtoRepository,
            TipoIVARepository tipoIVARepository
    ) {
        this.produtoRepository = produtoRepository;
        this.tipoIVARepository = tipoIVARepository;
    }

    @Override
    public ProdutoDto createProduto(ProdutoDto dto) {

        TipoIVA iva = tipoIVARepository.findById(dto.getIdIva())
                .orElseThrow(() ->
                        new EntityNotFoundException("IVA não encontrado"));

        Produto produto = ProdutoMapper.toEntity(dto);
        produto.setIdiva(iva);

        return ProdutoMapper.toDto(
                produtoRepository.save(produto)
        );
    }

    @Override
    public PageResponse<ProdutoDto> getAllProdutos(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        return PageMapper.toPageResponse(
                produtoRepository.findAll(pageable),
                ProdutoMapper::toDto
        );
    }

    @Override
    public ProdutoDto getProdutoById(int id) {

        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Produto não encontrado"));

        return ProdutoMapper.toDto(produto);
    }

    @Override
    public ProdutoDto updateProduto(ProdutoDto dto, int id) {

        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Produto não encontrado"));

        ProdutoMapper.updateEntityFromDto(dto, produto);

        return ProdutoMapper.toDto(
                produtoRepository.save(produto)
        );
    }

    @Override
    public void deleteProduto(int id) {

        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Produto não encontrado"));

        produtoRepository.delete(produto);
    }
}