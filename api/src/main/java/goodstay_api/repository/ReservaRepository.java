package goodstay_api.repository;

import goodstay_api.model.Reserva;
import goodstay_api.model.ReservaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, ReservaId> {
}
