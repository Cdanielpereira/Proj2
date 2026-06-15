package goodstay_api.repository;

import goodstay_api.model.Encomenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncomendaRepository extends JpaRepository<Encomenda, Integer> {
}
