package goodstay_api.repository;

import goodstay_api.model.Catering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CateringRepository extends JpaRepository<Catering, Integer> {
}