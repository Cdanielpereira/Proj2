package estg.ipvc.proj2.repository;

import estg.ipvc.proj2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
