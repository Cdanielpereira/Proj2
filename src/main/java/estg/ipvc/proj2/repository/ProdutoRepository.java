package estg.ipvc.proj2.repository;

import estg.ipvc.proj2.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
