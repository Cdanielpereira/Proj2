package goodstay_api.repository;

import goodstay_api.model.LinhaEnc;
import goodstay_api.model.LinhaEncId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinhaEncRepository extends JpaRepository<LinhaEnc, LinhaEncId> {
}
