package estg.ipvc.proj2.repository;

import estg.ipvc.proj2.model.LinhaManu;
import estg.ipvc.proj2.model.LinhaManuId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinhaManuRepository extends JpaRepository<LinhaManu, LinhaManuId> {
}
