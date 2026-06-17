package goodstay_api;

import goodstay_api.model.*;
import goodstay_api.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

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

                for (String t : new String[]{
                        "STAFF",
                        "RECEP",
                        "HR",
                        "GERENTE",
                        "SUPERADMIN"
                }) {

                    TipoFunc tf = new TipoFunc();
                    tf.setType(t);

                    tipoFuncRepository.save(tf);
                }
            }

            // =========================
            // TIPOS COLAB
            // =========================
            if (tipoColabRepository.count() == 0) {

                for (String t : new String[]{
                        "Fornecedor",
                        "Técnico",
                        "Catering"
                }) {

                    TipoColab tc = new TipoColab();
                    tc.setType(t);

                    tipoColabRepository.save(tc);
                }
            }

            // =========================
            // TIPOS QUARTO
            // =========================
            if (tipoQuartoRepository.count() == 0) {

                for (String t : new String[]{
                        "Single",
                        "Double",
                        "Suite"
                }) {

                    TipoQuarto tq = new TipoQuarto();
                    tq.setType(t);

                    tipoQuartoRepository.save(tq);
                }
            }

            // =========================
            // TIPOS ZONA
            // =========================
            if (tipoZonaRepository.count() == 0) {

                for (String t : new String[]{
                        "Quarto",
                        "Piscina",
                        "WC",
                        "SP",
                        "ZE"
                }) {

                    TipoZona tz = new TipoZona();
                    tz.setType(t);

                    tipoZonaRepository.save(tz);
                }
            }

            // =========================
            // IVA
            // =========================
            if (tipoIVARepository.count() == 0) {

                TipoIVA normal = new TipoIVA();
                normal.setType("Normal");
                normal.setValor(new BigDecimal("0.23"));
                tipoIVARepository.save(normal);

                TipoIVA interm = new TipoIVA();
                interm.setType("Intermedia");
                interm.setValor(new BigDecimal("0.13"));
                tipoIVARepository.save(interm);

                TipoIVA reduz = new TipoIVA();
                reduz.setType("Reduzida");
                reduz.setValor(new BigDecimal("0.06"));
                tipoIVARepository.save(reduz);
            }

            // =========================
            // CODIGOS POSTAIS
            // =========================
            if (cpostalRepository.count() == 0) {

                createCP(cpostalRepository,
                        "4900-001",
                        "Viana do Castelo");

                createCP(cpostalRepository,
                        "4700-001",
                        "Braga");

                createCP(cpostalRepository,
                        "4000-001",
                        "Porto");

                createCP(cpostalRepository,
                        "1000-001",
                        "Lisboa");
            }

            // =========================
            // NACIONALIDADES
            // =========================
            if (nacionalidadeRepository.count() == 0) {

                for (String n : new String[]{
                        "Portuguesa",
                        "Espanhola",
                        "Brasileira"
                }) {

                    Nacionalidade nat = new Nacionalidade();
                    nat.setNacionalidade(n);

                    nacionalidadeRepository.save(nat);
                }
            }

            // =========================
            // SUPERADMIN INICIAL
            // =========================
            if (funcionarioRepository.count() == 0) {

                User adminUser = userRepository
                        .findByUsername("admin")
                        .orElseGet(() -> {

                            User u = new User();

                            u.setUsername("admin");
                            u.setPassword("admin123");
                            u.setTelefone("999999999");

                            return userRepository.save(u);
                        });

                TipoFunc superAdminTipo = tipoFuncRepository
                        .findAll()
                        .stream()
                        .filter(t ->
                                "SUPERADMIN"
                                        .equalsIgnoreCase(
                                                t.getType()))
                        .findFirst()
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Tipo SUPERADMIN não encontrado"));

                Cpostal cp = cpostalRepository
                        .findAll()
                        .stream()
                        .findFirst()
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Código postal não encontrado"));

                Nacionalidade nacionalidade = nacionalidadeRepository
                        .findAll()
                        .stream()
                        .findFirst()
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Nacionalidade não encontrada"));

                Funcionario admin = new Funcionario();

                admin.setNome("Administrador");
                admin.setEmail("admin@goodstay.pt");
                admin.setSexo("M");
                admin.setRua("Sistema");
                admin.setPorta("1");

                admin.setDtNasc(
                        LocalDate.of(1990, 1, 1));

                admin.setIban(
                        "PT5000000000000000000000000");

                admin.setNif(
                        new BigDecimal("999999999"));

                admin.setIdUser(adminUser);
                admin.setIdTipofunc(superAdminTipo);
                admin.setCodPostal(cp);
                admin.setIdNacional(nacionalidade);

                funcionarioRepository.save(admin);

                System.out.println(
                        ">>> SUPERADMIN inicial criado.");
            }

            System.out.println(">>> BD inicial pronta.");
        };
    }

    private void createCP(
            CpostalRepository repo,
            String cod,
            String loc
    ) {

        Cpostal cp = new Cpostal();

        cp.setCodPostal(cod);
        cp.setLocalidade(loc);

        repo.save(cp);
    }
}