package estg.ipvc.proj2.repository;

import estg.ipvc.proj2.model.Limpeza;
import estg.ipvc.proj2.model.LimpezaId;
import org.springframework.data.repository.CrudRepository;

public interface LimpezaRepository extends CrudRepository<Limpeza, LimpezaId> {
}
