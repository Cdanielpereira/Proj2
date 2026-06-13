package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.produtodto.ProdutoDto;

public interface ProdutoService {

    ProdutoDto createProduto(ProdutoDto dto);

    PageResponse<ProdutoDto> getAllProdutos(int pageNo, int pageSize);

    ProdutoDto getProdutoById(int id);

    ProdutoDto updateProduto(ProdutoDto dto, int id);

    void deleteProduto(int id);
}