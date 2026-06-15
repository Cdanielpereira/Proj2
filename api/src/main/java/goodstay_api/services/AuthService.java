package goodstay_api.services;

import goodstay_api.dtos.common.LoginRequestDto;
import goodstay_api.dtos.common.LoginResponseDto;
import goodstay_api.model.Cliente;
import goodstay_api.model.Funcionario;
import goodstay_api.model.User;
import goodstay_api.repository.ClienteRepository;
import goodstay_api.repository.FuncionarioRepository;
import goodstay_api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;

    public AuthService(
            UserRepository userRepository,
            ClienteRepository clienteRepository,
            FuncionarioRepository funcionarioRepository
    ) {
        this.userRepository = userRepository;
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public LoginResponseDto login(LoginRequestDto dto) {

        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() ->
                        new RuntimeException("Utilizador não encontrado"));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Password inválida");
        }

        LoginResponseDto response = new LoginResponseDto();
        response.setUserId(user.getId());
        response.setName(user.getUsername());

        // =========================
        // CLIENTE
        // =========================
        Cliente cliente = clienteRepository.findByIdUser(user).orElse(null);

        if (cliente != null) {
            response.setRole("CLIENT");
            return response;
        }

        // =========================
        // FUNCIONARIO
        // =========================
        Funcionario funcionario = funcionarioRepository.findByIdUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Utilizador sem perfil associado"));

        String role = funcionario.getIdTipofunc()
                .getType()
                .toUpperCase();

        response.setRole(role);

        return response;
    }

}
