package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.Produto;
import estg.ipvc.proj2.repository.ProdutoRepository;
import estg.ipvc.proj2.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAllProdutos()
    {
        List<Produto> list = new ArrayList<>();
        for (Produto produto : produtoRepository.findAll())
        {
            list.add(produto);
        }
        return list;
    }
    public Optional<Produto> getProdutoById(Integer id)
    {
        return produtoRepository.findById(id);
    }

    public Produto createProduto(Produto produto) {return produtoRepository.save(produto);}
    public Produto updateProduto(Integer id, Produto produto)
    {
        if (produtoRepository.existsById(id))
        {
            produto.setId(id);
            return produtoRepository.save(produto);
        }
        return null;
    }
    public void deleteProduto(Integer id) {produtoRepository.deleteById(id);}

    public boolean produtoExists(Integer id) {return produtoRepository.existsById(id);}
}

