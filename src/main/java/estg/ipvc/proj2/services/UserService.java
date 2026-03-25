package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.User;
import estg.ipvc.proj2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers()
    {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }
    public Optional<User> getUserById(Integer id) {return userRepository.findById(id);}

    public User createUser(User user) {return userRepository.save(user);}
    public User updateUser(Integer id, User user)
    {
        if (userRepository.existsById(id))
        {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }
    public void deleteUser(Integer id) {userRepository.deleteById(id);}

    public boolean userExists(Integer id) {return userRepository.existsById(id);}

}
