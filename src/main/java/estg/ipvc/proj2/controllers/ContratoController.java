package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.model.Contrato;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/proj2/")

public class ContratoController {

    @GetMapping("/contrato")
    public ResponseEntity<List<Contrato>> getContratos(){
        List<Contrato> contratos = new ArrayList<>();
        return ResponseEntity.ok(contratos);
    }
}