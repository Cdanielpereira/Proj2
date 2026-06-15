package goodstay_api.repository;

import goodstay_api.model.LinhaManu;
import goodstay_api.model.LinhaManuId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinhaManuRepository extends JpaRepository<LinhaManu, LinhaManuId> {
}
