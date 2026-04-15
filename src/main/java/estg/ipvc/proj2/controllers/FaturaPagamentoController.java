package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.model.FaturaPagamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/proj2/")

public class FaturaPagamentoController {

    @GetMapping("/faturaPagamento")
    public ResponseEntity<List<FaturaPagamento>> getFaturasPagamento(){
        List<FaturaPagamento> faturasPagamento = new ArrayList<>();
        return ResponseEntity.ok(faturasPagamento);
    }
}