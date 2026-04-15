package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.model.Manutencao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/proj2/")

public class ManutencaoController {

    @GetMapping("/manutencao")
    public ResponseEntity<List<Manutencao>> getManutencoes(){
        List<Manutencao> manutencoes = new ArrayList<>();
        return ResponseEntity.ok(manutencoes);
    }
}