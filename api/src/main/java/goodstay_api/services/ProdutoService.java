package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.produtodto.ProdutoDto;

public interface ProdutoService {

    ProdutoDto createProduto(ProdutoDto dto);

    PageResponse<ProdutoDto> getAllProdutos(int pageNo, int pageSize);

    ProdutoDto getProdutoById(int id);

    ProdutoDto updateProduto(ProdutoDto dto, int id);

    void deleteProduto(int id);
}