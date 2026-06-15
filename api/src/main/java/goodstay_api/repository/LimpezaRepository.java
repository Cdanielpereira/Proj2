package goodstay_api.repository;

import goodstay_api.model.Limpeza;
import goodstay_api.model.LimpezaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LimpezaRepository extends JpaRepository<Limpeza, LimpezaId> {
}
