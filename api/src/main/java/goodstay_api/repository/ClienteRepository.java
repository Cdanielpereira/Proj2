package goodstay_api.repository;

import goodstay_api.model.Cliente;
import goodstay_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByIdUser(User user);
}
