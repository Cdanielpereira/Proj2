package estg.ipvc.proj2;

import estg.ipvc.proj2.model.User;
import estg.ipvc.proj2.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Proj2Application {

    public static void main(String[] args) {

        SpringApplication.run(Proj2Application.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository  userRepository) {

        return (args-> {
            System.out.println(userRepository.findAll());

        });
    }

    /*private void InsertUser(UserRepository userRepository) {

        userRepository.save(new User("Damian", "admin", "999666555"));
        userRepository.save(new User("Carla", "user", "999666555"));
        userRepository.save(new User("Joao", "user", "999666555"));
        userRepository.save(new User("Mary", "user", "999666555"));

    }*/
    }
