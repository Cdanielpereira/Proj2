package estg.ipvc.proj2.repository;

import estg.ipvc.proj2.model.Reserva;
import estg.ipvc.proj2.model.ReservaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, ReservaId> {
}
