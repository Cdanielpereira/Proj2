package estg.ipvc.proj2.repository;

import estg.ipvc.proj2.model.Vencimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VencimentoRepository extends JpaRepository<Vencimento, Integer> {
}
