package estg.ipvc.proj2.repository;

import estg.ipvc.proj2.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
