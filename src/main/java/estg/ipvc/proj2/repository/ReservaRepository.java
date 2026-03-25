package estg.ipvc.proj2.repository;

import estg.ipvc.proj2.model.Reserva;
import estg.ipvc.proj2.model.ReservaId;
import org.springframework.data.repository.CrudRepository;

public interface ReservaRepository extends CrudRepository<Reserva, ReservaId> {
}
