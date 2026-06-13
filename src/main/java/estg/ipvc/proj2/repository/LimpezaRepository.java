package estg.ipvc.proj2.repository;

import estg.ipvc.proj2.model.Limpeza;
import estg.ipvc.proj2.model.LimpezaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LimpezaRepository extends JpaRepository<Limpeza, LimpezaId> {
}
