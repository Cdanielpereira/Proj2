package goodstay_api.repository;

import goodstay_api.model.Nacionalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NacionalidadeRepository extends JpaRepository<Nacionalidade, Integer> {
    Optional<Nacionalidade> findByNacionalidadeIgnoreCase(String nacionalidade);
}
