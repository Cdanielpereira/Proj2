package estg.ipvc.proj2.repository;

import estg.ipvc.proj2.model.Cpostal;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CpostalRepository extends CrudRepository<Cpostal, String> {
    Optional<Cpostal> findByCodPostal(String codPostal);

    boolean existsByCodPostal(String codPostal);
}
