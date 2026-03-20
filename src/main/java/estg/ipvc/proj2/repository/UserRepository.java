package estg.ipvc.proj2.repository;

import estg.ipvc.proj2.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
