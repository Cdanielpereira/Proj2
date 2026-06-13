package estg.ipvc.proj2.repository;

import estg.ipvc.proj2.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
