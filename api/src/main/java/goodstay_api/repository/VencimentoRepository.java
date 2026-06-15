package goodstay_api.repository;

import goodstay_api.model.Vencimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VencimentoRepository extends JpaRepository<Vencimento, Integer> {
}
