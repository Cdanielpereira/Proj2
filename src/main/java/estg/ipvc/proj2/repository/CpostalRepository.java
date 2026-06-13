package estg.ipvc.proj2.repository;

import estg.ipvc.proj2.model.Cpostal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CpostalRepository extends JpaRepository<Cpostal, String> {
    Optional<Cpostal> findByCodPostal(String codPostal);

    boolean existsByCodPostal(String codPostal);
}
