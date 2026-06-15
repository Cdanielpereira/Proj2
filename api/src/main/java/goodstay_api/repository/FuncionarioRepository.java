package goodstay_api.repository;

import goodstay_api.model.Funcionario;
import goodstay_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    Optional<Funcionario> findByIdUser(User user);

}