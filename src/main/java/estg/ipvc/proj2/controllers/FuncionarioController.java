package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.model.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/proj2/")

public class FuncionarioController {

    @GetMapping("/funcionario")
    public ResponseEntity<List<Funcionario>> getFuncionarios(){
        List<Funcionario> funcionarios = new ArrayList<>();
        return ResponseEntity.ok(funcionarios);
    }
}