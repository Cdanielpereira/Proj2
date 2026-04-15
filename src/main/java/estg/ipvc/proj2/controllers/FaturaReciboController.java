package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.model.FaturaRecibo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/proj2/")

public class FaturaReciboController {

    @GetMapping("/faturaRecibo")
    public ResponseEntity<List<FaturaRecibo>> getFaturasRecibo(){
        List<FaturaRecibo> faturasRecibo = new ArrayList<>();
        return ResponseEntity.ok(faturasRecibo);
    }
}