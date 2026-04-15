package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.model.Quarto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/proj2/")

public class QuartoController {

    @GetMapping("/quarto")
    public ResponseEntity<List<Quarto>> getQuartos(){
        List<Quarto> quartos = new ArrayList<>();
        return ResponseEntity.ok(quartos);
    }
}