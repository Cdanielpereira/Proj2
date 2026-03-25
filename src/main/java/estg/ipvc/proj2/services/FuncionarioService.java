package estg.ipvc.proj2.services;

import estg.ipvc.proj2.model.Funcionario;
import estg.ipvc.proj2.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getAllFuncionarios()
    {
        List<Funcionario> list = new ArrayList<>();
        funcionarioRepository.findAll().forEach(list::add);
        return list;
    }
    public Optional<Funcionario> getFuncionarioById(Integer id)
    {
        return funcionarioRepository.findById(id);
    }

    public Funcionario createFuncionario(Funcionario funcionario)
    {
        return funcionarioRepository.save(funcionario);
    }
    public Funcionario updateFuncionario(Integer id, Funcionario funcionario)
    {
        if (funcionarioRepository.existsById(id))
        {
            funcionario.setId(id);
            return funcionarioRepository.save(funcionario);
        }
        return null;
    }
    public void deleteFuncionario(Integer id) {funcionarioRepository.deleteById(id);}

    public boolean funcionarioExists(Integer id)
    {
        return funcionarioRepository.existsById(id);
    }
}

