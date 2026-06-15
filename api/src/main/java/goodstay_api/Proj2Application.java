package goodstay_api;

import goodstay_api.model.*;
import goodstay_api.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class Proj2Application {

    public static void main(String[] args) {
        SpringApplication.run(Proj2Application.class, args);
    }

    @Bean
    public CommandLineRunner run(
            UserRepository userRepository,
            ClienteRepository clienteRepository,
            FuncionarioRepository funcionarioRepository,
            TipoFuncRepository tipoFuncRepository,
            TipoColabRepository tipoColabRepository,
            TipoQuartoRepository tipoQuartoRepository,
            TipoZonaRepository tipoZonaRepository,
            TipoIVARepository tipoIVARepository,
            CpostalRepository cpostalRepository,
            NacionalidadeRepository nacionalidadeRepository
    ) {

        return args -> {

            // =========================
            // TIPOS FUNC
            // =========================
            if (tipoFuncRepository.count() == 0) {
                for (String t : new String[]{"STAFF", "RECEP", "HR", "GERENTE", "SUPERADMIN"}) {
                    TipoFunc tf = new TipoFunc();
                    tf.setType(t);
                    tipoFuncRepository.save(tf);
                }
            }

            // =========================
            // TIPOS COLAB
            // =========================
            if (tipoColabRepository.count() == 0) {
                for (String t : new String[]{"Fornecedor", "Técnico", "Catering"}) {
                    TipoColab tc = new TipoColab();
                    tc.setType(t);
                    tipoColabRepository.save(tc);
                }
            }

            // =========================
            // TIPOS QUARTO
            // =========================
            if (tipoQuartoRepository.count() == 0) {
                for (String t : new String[]{"Single", "Double", "Suite"}) {
                    TipoQuarto tq = new TipoQuarto();
                    tq.setType(t);
                    tipoQuartoRepository.save(tq);
                }
            }

            // =========================
            // TIPOS ZONA
            // =========================
            if (tipoZonaRepository.count() == 0) {
                for (String t : new String[]{"Quarto", "Piscina", "WC", "SP", "ZE"}) {
                    TipoZona tz = new TipoZona();
                    tz.setType(t);
                    tipoZonaRepository.save(tz);
                }
            }

            // =========================
            // IVA
            // =========================
            if (tipoIVARepository.count() == 0) {

                TipoIVA a = new TipoIVA();
                a.setType("Normal");
                a.setValor(new BigDecimal("0.23"));
                tipoIVARepository.save(a);

                TipoIVA b = new TipoIVA();
                b.setType("Intermedia");
                b.setValor(new BigDecimal("0.13"));
                tipoIVARepository.save(b);

                TipoIVA c = new TipoIVA();
                c.setType("Reduzida");
                c.setValor(new BigDecimal("0.06"));
                tipoIVARepository.save(c);
            }

            // =========================
            // CP
            // =========================
            if (cpostalRepository.count() == 0) {

                createCP(cpostalRepository, "4900-001", "Viana do Castelo");
                createCP(cpostalRepository, "4700-001", "Braga");
                createCP(cpostalRepository, "4000-001", "Porto");
                createCP(cpostalRepository, "1000-001", "Lisboa");
            }

            // =========================
            // NACIONALIDADE
            // =========================
            if (nacionalidadeRepository.count() == 0) {

                for (String n : new String[]{"Portuguesa", "Espanhola", "Brasileira"}) {
                    Nacionalidade nat = new Nacionalidade();
                    nat.setNacionalidade(n);
                    nacionalidadeRepository.save(nat);
                }
            }

            // =========================
            // USERS
            // =========================
            if (userRepository.count() == 0) {

                createUser(userRepository, "admin", "1234");
                createUser(userRepository, "gerente", "1234");
                createUser(userRepository, "hr", "1234");
                createUser(userRepository, "recep", "1234");
                createUser(userRepository, "staff", "1234");
                createUser(userRepository, "client", "1234");
            }

            // =========================
            // CLIENTE
            // =========================
            if (clienteRepository.count() == 0) {

                User clientUser = userRepository.findByUsername("client").orElseThrow();

                Cliente c = new Cliente();
                c.setNome("Cliente Demo");
                c.setEmail("client@demo.com");
                c.setSexo("M");
                c.setIdUser(clientUser);

                clienteRepository.save(c);
            }

            // =========================
            // FUNCIONARIOS
            // =========================
            if (funcionarioRepository.count() == 0) {

                createFuncionario(funcionarioRepository, userRepository, tipoFuncRepository,
                        "staff", "STAFF");

                createFuncionario(funcionarioRepository, userRepository, tipoFuncRepository,
                        "recep", "RECEP");

                createFuncionario(funcionarioRepository, userRepository, tipoFuncRepository,
                        "hr", "HR");

                createFuncionario(funcionarioRepository, userRepository, tipoFuncRepository,
                        "gerente", "GERENTE");

                createFuncionario(funcionarioRepository, userRepository, tipoFuncRepository,
                        "admin", "SUPERADMIN");
            }

            System.out.println(">>> BD inicial pronta.");
        };
    }

    private void createUser(UserRepository repo, String username, String pass) {
        User u = new User();
        u.setUsername(username);
        u.setPassword(pass);
        u.setTelefone("900000000");
        repo.save(u);
    }

    private void createCP(CpostalRepository repo, String cod, String loc) {
        Cpostal cp = new Cpostal();
        cp.setCodPostal(cod);
        cp.setLocalidade(loc);
        repo.save(cp);
    }

    private void createFuncionario(
            FuncionarioRepository repo,
            UserRepository userRepo,
            TipoFuncRepository tipoRepo,
            String username,
            String tipo
    ) {

        User u = userRepo.findByUsername(username).orElseThrow();
        TipoFunc tf = tipoRepo.findAll()
                .stream()
                .filter(x -> x.getType().equals(tipo))
                .findFirst()
                .orElseThrow();

        Funcionario f = new Funcionario();
        f.setNome(username);
        f.setEmail(username + "@demo.com");
        f.setSexo("M");
        f.setIban("PT50TESTE000000000");
        f.setRua("Rua Demo");
        f.setPorta("1");
        f.setDtNasc(java.time.LocalDate.of(1990, 1, 1));
        f.setNif(new BigDecimal("123456789"));
        f.setIdUser(u);
        f.setIdTipofunc(tf);

        repo.save(f);
    }

}
