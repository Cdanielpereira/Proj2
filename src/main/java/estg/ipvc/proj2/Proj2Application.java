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
    public CommandLineRunner run(UserRepository userRepository) {
        return (args) -> {
            // 1. Inserir utilizadores de teste (só se a BD estiver vazia)
            if (userRepository.count() == 0) {
                insertUsers(userRepository);
                System.out.println(">>> Utilizadores de teste inseridos!");
            }

            // 2. Mostrar todos os utilizadores na consola
            System.out.println(">>> Lista de utilizadores na BD:");
            userRepository.findAll().forEach(System.out::println);
        };
    }

    private void insertUsers(UserRepository userRepository) {
        User u1 = new User();
        u1.setUsername("Damian");
        u1.setPassword("admin");
        u1.setTelefone("999666555");
        userRepository.save(u1);

        User u2 = new User();
        u2.setUsername("Carla");
        u2.setPassword("user");
        u2.setTelefone("999666555");
        userRepository.save(u2);

        User u3 = new User();
        u3.setUsername("Joao");
        u3.setPassword("user");
        u3.setTelefone("999666555");
        userRepository.save(u3);

        User u4 = new User();
        u4.setUsername("Mary");
        u4.setPassword("user");
        u4.setTelefone("999666555");
        userRepository.save(u4);
    }
}